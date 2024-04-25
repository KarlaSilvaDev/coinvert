
![Logo](https://i.imgur.com/SMYc4nf.png)

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

# Introdução
O conversor de moedas CoinVert é uma aplicação simples desenvolvida para consolidar alguns conhecimentos obtidos no curso de Java da Alura em parceria com a ONE (Oracle Next Education). O conversor consome a API externa ExchangeRate. (https://www.exchangerate-api.com/)

## Stack utilizada

**Front-end:** Não contemplado

**Back-end:** 
- JDK 21.0.2
- Gson 2.10.1
- Java Dotenv 5.2.2
- IntelliJ (IDE)


## Funcionalidades

- Realizar a conversão de moedas pré-definidas em um menu de navegação
- Realizar a conversão de moedas através de códigos de moeda inseridos pelo usuário
- Mostrar códigos de moeda suportados pela API

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar obter uma chave no site da API externa ExchangeRate e colocá-la na seguinte variável de ambiente no seu .env:

`API_KEY`

## Rodando o CoinVert

1) Clone o projeto

```bash
  git clone https://github.com/KarlaSilvaDev/conversor-de-moedas.git
```

2) Abra o projeto no IntelliJ ou outra IDE de sua preferência.

3) Instale as dependências

4) Execute o programa


## CoinVert em Funcionamento

![App Screenshot](https://i.imgur.com/1vC7IFQ.gif)


## Sugestões de Melhorias

 - Histórico de Conversões: Adicionar a capacidade de rastrear e exibir o histórico das últimas conversões realizadas, oferecendo aos usuários uma visão completa de suas atividades.

 - Registros de Logs: Utilizar as funções da biblioteca java.time para criar registros das conversões realizadas, incluindo informações sobre quais moedas foram convertidas e em que momento.

## Contribuindo

Pull-requests são bem-vindas. Para mudanças importantes, abra uma issue primeiro
para discutir o que você gostaria de mudar.

## Feedback

Se você tiver algum feedback, por favor me deixe saber por meio de karlasilvaeng@gmail.com



