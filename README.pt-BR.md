🌐 [English](README.md) | **Português (BR)**

# Microsserviços Bancários em Java

Plataforma bancária educacional construída com Java 21, Spring Boot, PostgreSQL, Kafka, Docker Compose e autenticação baseada em JWT.

## Arquitetura

- `account-service`: gestão de clientes e contas.
- `transaction-service`: depósitos, saques, transferências e histórico de transações.
- `api-gateway`: ponto de entrada único para roteamento e autenticação futuros.
- `shared`: contratos de domínio e utilitários comuns.

## Escopo atual

Este repositório foi pensado para aprender microsserviços, APIs REST, persistência, validação, mensageria e segurança. Não é um software bancário de produção e não deve processar dinheiro real de clientes.

## Requisitos

- Java 21+
- Maven 3.9+
- Docker e Docker Compose

## Subir as dependências

```bash
docker compose up -d postgres kafka
```

Rode cada serviço a partir do seu diretório com `./mvnw spring-boot:run` ou `mvn spring-boot:run`.

## Principais endpoints

### Account service

- `POST /api/customers`
- `GET /api/customers/{id}`
- `POST /api/accounts`
- `GET /api/accounts/{id}`

### Transaction service

- `POST /api/transactions/deposit`
- `POST /api/transactions/withdraw`
- `POST /api/transactions/transfer`
- `GET /api/transactions/account/{accountId}`

## Decisões de design

- Valores monetários usam `BigDecimal`.
- Operações que mudam estado são transacionais.
- Erros de negócio usam respostas JSON estruturadas.
- Cada serviço é dono dos seus dados e se comunica por HTTP/eventos.
- Segredos são fornecidos por variáveis de ambiente.

## Aviso

Projeto somente educacional. Ele não implementa os requisitos regulatórios, operacionais, de segurança, de auditoria, de resiliência e de conformidade de uma instituição financeira real.

## Histórico de desenvolvimento

Este projeto foi desenvolvido localmente entre 26/11/2025 e 19/09/2026. O histórico de commits foi criado depois, e as datas dos commits foram ajustadas para corresponder ao período em que o trabalho foi realmente feito.
