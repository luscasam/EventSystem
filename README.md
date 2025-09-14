# 📘 README - Sistema de Cadastro e Notificação de Eventos

## 👤 Autor
- **Nome:** Lucas de Sousa Alves Meneses  
- **Faculdade:** Universidade São Judas Tadeu  
- **Curso:** Análise e Desenvolvimento de Sistemas  

---

## 📖 Descrição do Projeto
Este projeto foi desenvolvido como parte da atividade prática da disciplina **Imersão Digital**, visando aplicar os conhecimentos adquiridos ao longo da formação em programação.  

O sistema consiste em uma aplicação **Java (Console)** orientada a objetos, com foco na **automação de processos de cadastro e notificação de eventos** que ocorrem na cidade do estudante.  

---

## 🎯 Objetivos
- Praticar conceitos de **Programação Orientada a Objetos (POO)**;  
- Utilizar um **repositório Git/GitHub** para versionamento e entrega;  
- Implementar funcionalidades de cadastro, consulta e gerenciamento de eventos;  
- Consolidar a lógica de programação e boas práticas de desenvolvimento.  

---

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java  
- **IDE Sugerida:** Eclipse (pode ser utilizado NetBeans, IntelliJ ou Replit)  
- **Controle de versão:** Git/GitHub  

---

## 📌 Funcionalidades Implementadas
O sistema atende às seguintes especificações:  

- Cadastro de usuários com atributos definidos (mínimo 3 atributos obrigatórios).  
- Cadastro de eventos com os atributos:  
  - Nome  
  - Endereço  
  - Categoria  
  - Horário  
  - Descrição  
- Definição de categorias de eventos (festas, esportivos, shows, etc).  
- Consulta de eventos cadastrados e possibilidade de participação.  
- Visualização de eventos em que o usuário está confirmado, com opção de cancelar participação.  
- Ordenação de eventos por data/hora, indicando próximos e ocorrendo no momento.  
- Registro de eventos já ocorridos.  
- Persistência dos dados em arquivo de texto (`eventos.data`).  
- Carregamento automático dos eventos salvos ao iniciar o sistema.  

---

## 📂 Estrutura do Projeto
```bash
📁 src/
 ┣ 📜 Main.java
 ┣ 📜 Usuario.java
 ┣ 📜 Evento.java
 ┣ 📜 GerenciadorEventos.java
 ┗ 📜 Utils.java
📁 data/
 ┗ 📜 eventos.data
📜 README.md
```

---

## ▶️ Como Executar
1. Clone o repositório:  
   ```bash
   git clone https://github.com/lucasmeneses/eventos-console.git
   ```
   > 🔗 **Substitua o link acima pelo repositório real que você criar no GitHub.**  

2. Abra o projeto em sua IDE Java preferida (Eclipse recomendado).  
3. Compile e execute o arquivo **Main.java**.  

---

## ✅ Considerações Finais
Este trabalho reforça a importância da prática no desenvolvimento de sistemas, consolidando os fundamentos de **POO, lógica de programação e versionamento com Git**.  
