# PicPay Simplificado  
Projeto desenvolvido em Java com Spring Boot, simulando funcionalidades básicas de uma carteira digital, como criação de usuários, transferências entre usuários e validações de saldo.  

---

## Funcionalidades  
- **Criação de usuários:** Cadastro de novos usuários com nome, documento (CPF/CNPJ), email, senha e saldo inicial.  
- **Transferências entre usuários:** Realização de transferências com validação de saldo e tipo de usuário (Lojistas não podem realizar transferências).  
- **Validações:**  
  - Verificação de saldo suficiente para transferências.  
  - Validação de tipo de usuário (Comum ou Lojista).  
  - Verificação de autorização externa (simulada).  
- **Notificações:** Envio de notificações simuladas para usuários após transferências.  

---

## Tecnologias Utilizadas  
- **Linguagem:** Java (Spring Boot).  
- **Banco de Dados:** H2 (banco de dados em memória).  
- **Ferramentas:** IntelliJ IDEA, Git, Postman.  
- **Dependências:**  
  - Spring Web  
  - Spring Data JPA  
  - Validation  
  - H2 Database  
  - Lombok (para redução de boilerplate code).  

---

## Como Executar  
1. **Pré-requisitos:**  
   - Java Development Kit (JDK) 11 ou superior.  
   - Maven instalado.  
   - IntelliJ IDEA ou outra IDE de sua preferência.  

2. **Passos:**  
   - Clone o repositório:  
     ```bash
     git clone https://github.com/Leo-Angelo1/Picpay.git
     ```  
   - Abra o projeto no IntelliJ IDEA.  
   - Execute a classe `PicpaySimplificadoApplication` para iniciar a aplicação.  

3. **Acessando o Banco de Dados H2:**  
   - Após iniciar a aplicação, acesse o console do H2 em:  
     ```
     http://localhost:8080/h2-console
     ```  
   - Use as seguintes credenciais:  
     - **JDBC URL:** `jdbc:h2:mem:picpay`  
     - **User Name:** `sa`  
     - **Password:** (deixe em branco)  

4. **Testando a API:**  
   - Use o Postman ou cURL para testar os endpoints:  
     - **Criar usuário:**  
       ```bash
       curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"firstName": "Leonardo", "lastName": "Angelo", "document": "12345678900", "email": "leo@example.com", "password": "senha123", "balance": 1000, "userType": "COMMON"}'
       ```  
     - **Realizar transferência:**  
       ```bash
       curl -X POST http://localhost:8080/transactions -H "Content-Type: application/json" -d '{"senderId": 1, "receiverId": 2, "amount": 500}'
       ```  

---

## Estrutura do Projeto  
- **`src/main/java/com/picpaysimplificado/domain`:** Contém as entidades do domínio (User, Transaction).  
- **`src/main/java/com/picpaysimplificado/dto`:** Contém os DTOs (Data Transfer Objects) para transferência de dados.  
- **`src/main/java/com/picpaysimplificado/repositories`:** Contém os repositórios para acesso ao banco de dados.  
- **`src/main/java/com/picpaysimplificado/services`:** Contém a lógica de negócio (UserService, TransactionService).  
- **`src/main/java/com/picpaysimplificado/controllers`:** Contém os controllers da API (UserController, TransactionController).  
- **`src/main/resources`:** Contém arquivos de configuração (`application.properties`).  

---

## Endpoints da API  
### **Usuários**  
- **POST /users:** Cria um novo usuário.  
  - Exemplo de corpo da requisição:  
    ```json
    {
      "firstName": "Leonardo",
      "lastName": "Angelo",
      "document": "12345678900",
      "email": "leo@example.com",
      "password": "senha123",
      "balance": 1000,
      "userType": "COMMON"
    }
    ```  

### **Transações**  
- **POST /transactions:** Realiza uma transferência entre usuários.  
  - Exemplo de corpo da requisição:  
    ```json
    {
      "senderId": 1,
      "receiverId": 2,
      "amount": 500
    }
    ```  

---

## Próximos Passos  
- Implementar autenticação e autorização com Spring Security.  
- Adicionar testes unitários e de integração com JUnit e Mockito.  
- Substituir o banco de dados H2 por um banco de dados persistente (ex: PostgreSQL).  
- Documentar a API com Swagger.  

---

## Contribuição  
Contribuições são bem-vindas! Siga os passos abaixo:  
1. Faça um fork do projeto.  
2. Crie uma branch para sua feature:  
   ```bash
   git checkout -b feature/nova-feature
