package com.alura.tabela_fipe.principal;

import com.alura.tabela_fipe.model.Dados;
import com.alura.tabela_fipe.model.Modelos;
import com.alura.tabela_fipe.model.Veiculo;
import com.alura.tabela_fipe.service.ConsumoApi;
import com.alura.tabela_fipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private String url = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        System.out.println("**** OPÇÕES ****\n" +
                "Carro\n" +
                "Moto\n" +
                "Caminhão\n" +
                "Digite uma das opções para consultar valores:"
        );
        String tipoVeiculo = leitura.nextLine();
        var endereco = "";
        if (tipoVeiculo.toLowerCase().contains("carr")){
             endereco = url + "carros" + "/marcas";
        } else if (tipoVeiculo.toLowerCase().contains("mot")) {
            endereco = url + "motos" + "/marcas";
        } else{
             endereco = url + "caminhoes" + "/marcas";
        }
        var json = consumo.obterDados(endereco);
        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Digite o código da marca para consulta: ");
        String marca = leitura.nextLine();

        endereco = endereco + "/" + marca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);
        System.out.println("Modelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro");
        var nome = leitura.nextLine();
        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("\nModelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite o código do modelo escolhido");
        var modelo = leitura.nextLine();
        endereco = endereco + "/" + modelo + "/anos";
        json = consumo.obterDados(endereco);
        List<Dados> anos = conversor.obterLista(json, Dados.class);

        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("Todos os veiculos filtrados");
        veiculos.forEach(System.out::println);
    }
}
