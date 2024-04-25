
![Logo](https://i.imgur.com/SMYc4nf.png)

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

## Introdução 

O CoinVert é um programa simples, desenvolvido em Java, que permite a conversão de valores entre diferentes moedas de forma rápida e fácil. Para  isso, o usuário deve apenas escolher uma das opções de conversão do menu e informar o valor que deseja converter. Além das opções pré-definidas no menu, há uma opção em que o usuário pode simplesmente digitar o código da moeda base e da moeda alvo. 

Esse aplicativo foi criado com o intuito de cumprir um desafio proposto durante o curso de Java da Alura em parceria com a ONE (Oracle Next Education) e consolidar os conhecimentos obtidos até essa etapa do curso.

  <div style="flex: 1; text-align: center;">
    <img alt="Badge ONE (Oracle Next Education)" height="300" src="https://i.imgur.com/mjWiHki.png">
  </div>


## Stack utilizada

**Front-end:** Não contemplado

**Back-end:** 
- JDK 21.0.2
- Gson 2.10.1
- Java Dotenv 5.2.2
- IntelliJ (IDE)


## Funcionalidades

- Conversão de moedas utilizando a API Externa [ExchangeRate](https://www.exchangerate-api.com/)
- Suporte para várias moedas, incluindo Dólar, Peso Argentino, Real Brasileiro, Peso Colombiano e muito mais

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

4) Execute a classe Main presente no diretório


## CoinVert em Funcionamento

![App Screenshot](https://i.imgur.com/1vC7IFQ.gif)


## Códigos de Moeda Suportados

A lista de códigos de moeda suportados pode ser acessada no site da API Externa Exchange Rate ([clique aqui](https://www.exchangerate-api.com/docs/supported-currencies))

## Sugestões de Melhorias

 - Histórico de Conversões: Adicionar a capacidade de rastrear e exibir o histórico das últimas conversões realizadas, oferecendo aos usuários uma visão completa de suas atividades.

 - Registros de Logs: Utilizar as funções da biblioteca java.time para criar registros das conversões realizadas, incluindo informações sobre quais moedas foram convertidas e em que momento.

## Contribuindo

Pull-requests são bem-vindas. Para mudanças importantes, abra uma issue primeiro
para discutir o que você gostaria de mudar.

## Feedback

Se você tiver algum feedback, por favor me deixe saber por meio de karlasilvaeng@gmail.com



