# 🧾 Benefícios API

Esta aplicação é uma API REST construída com **Java 17 + Spring Boot** para o gerenciamento de benefícios. Foi desenvolvida como parte de um desafio técnico com foco em boas práticas, Clean Code e uso de tecnologias modernas.

---

## Funcionalidades

A API permite:

-  Criar benefícios
-  Listar todos os benefícios
-  Ativar e desativar um benefício
-  Excluir um benefício
-  Validação dos campos com Jakarta Bean Validation
- Uso de banco H2 em memória

---

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.4.8
- Spring Data JPA
- H2 Database
- Lombok
- Gradle
- JUnit 5 + MockMvc (opcional)

---

##  Como rodar o projeto

### Pré-requisitos
- JDK 17 instalado
- **Não é necessário instalar o Gradle** (usa wrapper)

### Passos

1. Clone ou baixe este repositório
2. Abra um terminal na raiz do projeto
3. Execute:

```bash
# No Windows
.\gradlew.bat bootRun

# No Linux/macOS
./gradlew bootRun
