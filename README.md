# Desafio PicPay

Este projeto é uma solução para o desafio de backend proposto pelo PicPay, que envolve a implementação de um sistema de transferências entre usuários. A aplicação foi desenvolvida utilizando Java com Spring Boot, conforme descrito em projetos semelhantes encontrados em repositórios públicos.

## Tecnologias Utilizadas

Com base em soluções similares, as seguintes tecnologias foram empregadas:

- **Java 21**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **Spring Boot 3.x**: Framework que simplifica a criação de aplicações Java robustas e escaláveis.
- **Spring Data JPA**: Abstração para interações com bancos de dados relacionais.
- **Spring Web**: Módulo do Spring para construção de APIs RESTful.
- **Spring Cloud OpenFeign**: Cliente HTTP declarativo para chamadas a serviços externos.
- **Lombok**: Biblioteca que reduz o código boilerplate através de anotações.
- **Docker**: Plataforma de conteinerização para facilitar a implantação e o desenvolvimento.

## Funcionalidades Implementadas

A aplicação oferece as seguintes funcionalidades:

- **Transferências entre Usuários**: Usuários podem realizar transferências de saldo entre si. Lojistas apenas recebem transferências.
- **Validação de Saldo**: Antes de efetuar uma transferência, o sistema verifica se o pagador possui saldo suficiente.
- **Autorização de Transações**: Integração com serviço externo para autorização das transferências.
- **Notificações**: Envio de notificações aos usuários após a conclusão de uma transferência.

## Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

- **domain**: Contém as classes principais do domínio, como `User`, `UserType` e `Transaction`.
- **dtos**: Data Transfer Objects utilizados para transferência de dados entre as camadas da aplicação.
- **services**: Contém a lógica de negócios, como `TransactionService` e `NotificationService`.
- **repositories**: Interfaces JPA para acesso ao banco de dados.
- **controllers**: Controladores REST que expõem a API da aplicação.

## Configuração e Execução

Para executar o projeto, siga os passos abaixo:

1. **Pré-requisitos**:
   - JDK 21 instalado.
   - Apache Maven instalado.

2. **Clonar o Repositório**:
   ```bash
   git clone https://github.com/Talisson-b99/desafio-picpay.git
   cd desafio-picpay
   ```

3. **Instalar Dependências**:
   ```bash
   mvn clean install
   ```

4. **Executar a Aplicação**:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`.



