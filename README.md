# 🏠 Teto: Organização sob o mesmo teto

O **Teto** é um aplicativo gerenciador de tarefas domésticas focado em **Auditabilidade** e **Flexibilidade**. Criado para repúblicas, famílias e colivings, ele atua como um mediador imparcial, transformando o esforço doméstico em um sistema logístico justo através de um Mercado de Trocas e Validação por Pares.

## 🛠️ Stack Tecnológica & Arquitetura
* **Backend:** Java 21, Spring Boot 3, Spring Security, Spring Data JPA.
* **Frontend:** React Native, Expo, TypeScript, Zustand.
* **Banco de Dados:** PostgreSQL (via Docker).
* **Arquitetura Base:** O projeto segue o padrão **MVC (Model-View-Controller)** estruturado dentro de um **Monolito Modular**. 
* **Design Patterns:** Utilizamos o **Padrão Repository** para isolar a camada de acesso a dados e **DTOs (Data Transfer Objects)** para encapsular e transportar os dados de forma segura entre as requisições e as entidades do banco.

---

## ⚙️ Pré-requisitos
Antes de começar, certifique-se de ter as ferramentas abaixo instaladas:
* [Java 21 (JDK)](https://adoptium.net/)
* [Node.js](https://nodejs.org/) (versão LTS recomendada)
* [Docker e Docker Compose](https://www.docker.com/)
* [Expo CLI](https://docs.expo.dev/) (Instale globalmente rodando: `npm install -g expo-cli`)
* **Expo Go** instalado no seu smartphone (iOS ou Android) para testes físicos.

---

## 🚀 Passo a Passo: Do Clone ao App Rodando

### Passo 0: Clonar o Repositório
Faça o clone do projeto para a sua máquina e entre na pasta raiz:

```bash
git clone [https://github.com/ZamohtX/teto.git](https://github.com/ZamohtX/teto.git)
cd teto
```

### Passo 1: Variáveis de Ambiente

Nós não commitamos senhas. Você precisa criar o seu arquivo de ambiente local.

    Na raiz do projeto, crie uma cópia do arquivo .env.example e renomeie para .env.

    O arquivo já vem com os valores padrões para rodar o ambiente de desenvolvimento.

### Passo 2: Subir o Banco de Dados

O PostgreSQL está configurado via Docker. Para subir o banco:
```Bash
cd teto-backend
docker-compose up -d
```
O banco de dados estará rodando na porta 5432.

### Passo 3: Rodar o Backend (API Java)

Ainda dentro da pasta teto-backend, inicie o servidor do Spring Boot:

No Mac/Linux:

```Bash
./mvnw spring-boot:run
```
No Windows:
```Bash
.\mvnw spring-boot:run
```
O backend estará rodando e conectado ao banco. A API responderá em http://localhost:8080.

### Passo 4: Rodar o Frontend (App Mobile)

Abra uma nova aba no terminal (deixe o backend rodando na primeira), volte para a raiz do projeto e entre na pasta do mobile:

```Bash
cd teto-mobile
npm install
npm start
```
Um QR Code aparecerá no seu terminal. Abra o aplicativo Expo Go no seu celular, escaneie o código e o app do Teto será compilado e aberto na sua tela!

---
## 📝 Padrão de Commits (Conventional Commits)

Para mantermos o histórico do repositório organizado e legível, utilizamos o padrão de Conventional Commits. Todo commit deve seguir a estrutura: tipo: descrição breve.

- **feat**: Uma nova funcionalidade (ex: feat: cria endpoint de login).
- **fix**: Correção de um bug (ex: fix: resolve erro de calculo no mercado de tarefas).
- **chore**: Atualizações de ferramentas, dependências ou configurações que não afetam o código em produção (ex: chore: atualiza versão do expo).
- **refactor**: Mudança de código que não corrige um bug nem adiciona uma feature, mas melhora a estrutura (ex: refactor: extrai lógica de pontos para um service).
- **docs**: Alterações apenas na documentação (ex: docs: atualiza instruções no README).
- **style**: Formatação de código, falta de ponto e vírgula, etc (ex: style: formata arquivos com prettier).
---

## 🤝 Guia de Contribuição

O backend é um Monolito Modular dividido em domínios (users, tasks, market, gamification). Ao desenvolver uma nova feature, siga este fluxo rigorosamente:

- **Model (Entidades)**: Defina a estrutura no banco de dados.
- **Repository**: Crie a interface para comunicação com o PostgreSQL.
- **DTOs**: Defina os objetos de entrada (Requests) e saída (Responses) da sua feature.
- **Service**: Isole toda a lógica de negócio aqui. O Controller não deve ter regras complexas.
- **Controller**: Exponha os endpoints da API conectando os DTOs aos Services.
