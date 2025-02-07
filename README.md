
# FIPE Spring

Este repositório contém uma aplicação desenvolvida com o Spring Framework que consome a API da Tabela FIPE para consultar valores de veículos baseados na marca, modelo e ano. O objetivo deste projeto é permitir que o usuário consulte os preços de veículos de acordo com os dados fornecidos pela API.

## Desafio

O objetivo principal é simular a consulta de valores de veículos, como no site da Tabela FIPE, mas de forma simplificada, onde o usuário escolhe apenas a **marca** e o **modelo** do carro. A partir dessas escolhas, o programa irá listar os preços de todos os anos disponíveis para aquele veículo.

## Funcionalidade

1. **Escolha do Tipo de Veículo:**
   O usuário pode escolher entre as opções:
   - Carro
   - Moto
   - Caminhão

2. **Seleção da Marca:**
   Após escolher o tipo de veículo, o usuário deve digitar o código da marca desejada. O sistema retorna uma lista de marcas, cada uma com seu código de identificação.

3. **Escolha do Modelo:**
   Após selecionar a marca, o usuário deve informar um trecho do nome do modelo desejado. O sistema então retorna uma lista de modelos com os respectivos códigos.

4. **Consulta de Preços por Ano:**
   O usuário escolhe o modelo e, em seguida, o sistema retorna os preços de todos os anos cadastrados na tabela FIPE para aquele modelo.

## Como Executar

### Requisitos

- Java 8 ou superior
- Maven
- IDE (ex: IntelliJ IDEA, Eclipse)

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/arthurarraes/consulta-precos-fipe.git
   cd fipe-spring
   ```

2. Compile o projeto utilizando o Maven:
   ```bash
   mvn clean install
   ```

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

4. O terminal apresentará o menu de opções, onde você pode interagir com a aplicação:
   - Digite "Carro", "Moto" ou "Caminhão" para escolher o tipo de veículo.
   - Digite o código da marca para consultar a marca desejada.
   - Digite um trecho do nome do veículo para consultar os modelos.
   - Escolha o código do modelo para consultar os preços por ano.

### Exemplo de Execução

```bash
**** OPÇÕES ****
Carro
Moto
Caminhão

Digite uma das opções para consultar valores:
Carro
Cód: 42 Descrição: Miura
Cód: 43 Descrição: Nissan
Cód: 44 Descrição: Peugeot
...
Informe o código da marca para consulta:
21
Digite um trecho do nome do veículo para consulta:
palio
Cód: 554 Descrição: Palio Weekend ELX 1.6 mpi
...
Digite o código do modelo para consultar valores:
545

Veiculo [valor=R$ 15.872,00, marca=Fiat, modelo=Palio Weekend Adventure 1.6 8V/16V, ano=2003, combustivel=Gasolina
Veiculo [valor=R$ 14.403,00, marca=Fiat, modelo=Palio Weekend Adventure 1.6 8V/16V, ano=2002, combustivel=Gasolina
Veiculo [valor=R$ 13.435,00, marca=Fiat, modelo=Palio Weekend Adventure 1.6 8V/16V, ano=2001, combustivel=Gasolina
```

## Tecnologias Utilizadas

- **Spring Boot**: Framework utilizado para a construção da aplicação.
- **Maven**: Gerenciador de dependências e build.
- **API FIPE**: Fonte de dados para valores de veículos.

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
