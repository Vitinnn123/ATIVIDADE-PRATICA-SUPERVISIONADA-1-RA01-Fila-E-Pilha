# Sistema de Gerenciamento de Atendimento ao Cliente em Java (Fila e Pilha)
- **Disciplina:** Resolução de Problemas Estruturados em Computação
- **Instituição:** Pontifícia Universidade Católica do Paraná    
- **Professor:** Andrey Cabral Meira
- **Alunos:**  
  - Gustavo Ferronatto Ribeiro — [@gustavoferronattoribeiro](https://github.com/gustavoferronattoribeiro)
  - Sophia Post Ploposki — [@sosopost](https://github.com/sosopost)  
  - Victor Augusto Esmaniotto — [@Vitinnn123](https://github.com/Vitinnn123) 
---

## Objetivo
O objetivo deste projeto é criar em Java um sistema de atendimento ao cliente utilizando listas encadeadas para implementar duas estruturas: uma fila, que organiza a ordem de atendimento, e uma pilha, que armazena o histórico de solicitações.

---

## Estrutura do Projeto

```
/Projeto Atendimento (Fila E Pilha)
└── README.md (Documentação do projeto)
  /Código Completo (Comentado)
  └── Main.java
  /Código Completo (Não Comentado)
  └── Main.java
```

---
# Explicação Código

## Estrutura do Código

### Classe `Elemento`
Essa classe representa os dados que serão armazenados tanto na pilha quanto na fila.  
Ela possui os seguintes atributos:

- `id` > Identificador (pode ser o ID da solicitação ou do cliente)  
- `nome` > Nome do cliente (usado na fila)  
- `descricao` > Motivo ou descrição do atendimento  
- `dataHora` > Data e hora da solicitação (usado na pilha)

Quando um campo não se aplica, é passado como `null`.  
Por exemplo, na pilha o `nome` é `null`, e na fila o `dataHora` é `null`.

---

### Classe `Node`
Essa é a base da **lista encadeada**.  
Cada nó (`Node`) armazena:
- Um objeto `Elemento` (os dados)
- Um ponteiro `proximo`, que aponta para o próximo nó da lista.

---

### Classe `Pilha` — Histórico de Solicitações
A **Pilha** segue o conceito de **LIFO (Last In, First Out)**, ou seja, o último elemento que entra é o primeiro a sair.  
Aqui, ela representa o **histórico de solicitações** feitas pelos clientes.

**Principais métodos:**
- `empilhar(Elemento e)` > Adiciona uma nova solicitação no topo da pilha.  
- `desempilhar()` > Remove a solicitação mais recente.  
- `estaVazia()` > Verifica se a pilha está vazia.  
- `exibir()` > Mostra todas as solicitações registradas no histórico.  

**Exemplo prático:**  
Se o cliente fizer 3 solicitações, a última registrada é a primeira que pode ser removida do histórico.

---

### Classe `Fila` — Ordem de Atendimento
A **Fila** segue o conceito de **FIFO (First In, First Out)**, ou seja, o primeiro cliente que entra é o primeiro a ser atendido.  
Aqui, ela representa a **fila de atendimento dos clientes**.

**Principais métodos:**
- `enfileirar(Elemento e)` > Adiciona um cliente no fim da fila.  
- `desenfileirar()` > Remove (ou “atende”) o cliente que está na frente.  
- `estaVazia()` > Verifica se a fila está vazia.  
- `exibir()` > Mostra todos os clientes aguardando atendimento.  

**Exemplo prático:**  
O primeiro cliente que chega é o primeiro a ser atendido, como em uma fila de banco.

---

### Classe `Main`
Aqui é onde o programa é executado.  
No método `main`, o código:

1. Cria a pilha de **histórico de solicitações** e a fila de **atendimento de clientes**.  
2. Adiciona solicitações na pilha (com data e hora).  
3. Exibe o histórico completo.  
4. Remove a solicitação mais recente e exibe novamente.  
5. Adiciona clientes na fila de atendimento.  
6. Exibe a fila completa.  
7. Atende (remove) o primeiro cliente e mostra a fila atualizada.  

Durante a execução, o programa mostra no console o que está acontecendo em cada etapa, de forma bem clara.

---

## Conceitos 

| Conceito | Explicação |
|-----------|------------|
| **Lista Encadeada** | Estrutura onde cada elemento aponta para o próximo. |
| **Pilha (LIFO)** | Último a entrar é o primeiro a sair — ideal para históricos. |
| **Fila (FIFO)** | Primeiro a entrar é o primeiro a sair — ideal para atendimentos em ordem. |

---

## Exemplo de Saída 

```
Solicitação adicionada ao histórico: REQ001 - Instalação de software
Solicitação adicionada ao histórico: REQ002 - Manutenção preventiva
Solicitação adicionada ao histórico: REQ003 - Atualização de sistema
Solicitação adicionada ao histórico: REQ004 - Suporte técnico

- HISTÓRICO DE SOLICITAÇÕES -
ID: REQ004 | Descrição: Suporte técnico | Data/Hora: 2024-08-20 12:00
ID: REQ003 | Descrição: Atualização de sistema | Data/Hora: 2024-08-20 11:30
ID: REQ002 | Descrição: Manutenção preventiva | Data/Hora: 2024-08-20 11:00
ID: REQ001 | Descrição: Instalação de software | Data/Hora: 2024-08-20 10:30
---------------------------------

Removido do histórico: REQ004 - Suporte técnico

- HISTÓRICO DE SOLICITAÇÕES -
ID: REQ003 | Descrição: Atualização de sistema | Data/Hora: 2024-08-20 11:30
ID: REQ002 | Descrição: Manutenção preventiva | Data/Hora: 2024-08-20 11:00
ID: REQ001 | Descrição: Instalação de software | Data/Hora: 2024-08-20 10:30
---------------------------------

Cliente adicionado à fila: Maria Silva - Dúvida sobre produto
Cliente adicionado à fila: João Souza - Reclamação de serviço
Cliente adicionado à fila: Ana Costa - Solicitação de reembolso

- FILA DE ATENDIMENTO -
1º -> Maria Silva (Dúvida sobre produto)
2º -> João Souza (Reclamação de serviço)
3º -> Ana Costa (Solicitação de reembolso)
----------------------------

Atendido: Maria Silva - Dúvida sobre produto

- FILA DE ATENDIMENTO -
1º -> João Souza (Reclamação de serviço)
2º -> Ana Costa (Solicitação de reembolso)
----------------------------
```

---

## Licença

Este projeto foi desenvolvido **exclusivamente para fins educacionais** na disciplina de *Resolução de Problemas Estruturados em Computação* da Pontifícia Universidade Católica do Paraná.
Não possui finalidade comercial e não concede direitos de uso além do contexto acadêmico.
