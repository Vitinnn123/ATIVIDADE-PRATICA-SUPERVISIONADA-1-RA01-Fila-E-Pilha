class Elemento {
    String id;
    String descricao;
    String dataHora;   // usado para histórico
    String nome;       // usado para fila

    // Construtor Geral
    Elemento(String id, String nome, String descricao, String dataHora) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }
}

// Nó da lista encadeada
class Node {
    Elemento dado;
    Node proximo;

    Node(Elemento e) {
        this.dado = e;
        this.proximo = null;
    }
}

// Pilha
class Pilha {
    private Node topo;

    // Adiciona elemento ao topo
    public void empilhar(Elemento e) {
        Node novo = new Node(e);
        novo.proximo = topo;
        topo = novo;
        System.out.println("Solicitação adicionada ao histórico: " + e.id + " - " + e.descricao);
    }

    // Remove elemento do topo
    public Elemento desempilhar() throws Exception {
        if (estaVazia()) {
            throw new Exception("Histórico vazio! Nenhuma solicitação para remover.");
        }
        Elemento removido = topo.dado;
        topo = topo.proximo;
        System.out.println("Removido do histórico: " + removido.id + " - " + removido.descricao);
        return removido;
    }

    // Verifica se a pilha está vazia
    public boolean estaVazia() {
        return topo == null;
    }

    // Exibe todo o histórico
    public void exibir() {
        if (estaVazia()) {
            System.out.println("Histórico vazio!");
            return;
        }
        System.out.println("\n- HISTÓRICO DE SOLICITAÇÕES -");
        Node atual = topo;
        while (atual != null) {
            System.out.println("ID: " + atual.dado.id + " | Descrição: " + atual.dado.descricao + " | Data/Hora: " + atual.dado.dataHora);
            atual = atual.proximo;
        }
        System.out.println("---------------------------------\n");
    }
}

// Fila
class Fila {
    private Node frente;
    private Node tras;

    // Cliente vai pro fim da fila
    public void enfileirar(Elemento e) {
        Node novo = new Node(e);
        if (tras == null) {
            frente = novo;
            tras = novo;
        } else {
            tras.proximo = novo;
            tras = novo;
        }
        System.out.println("Cliente adicionado à fila: " + e.nome + " - " + e.descricao);
    }

    // Atende o Cliente (Remove ele da fila)
    public Elemento desenfileirar() throws Exception {
        if (estaVazia()) {
            throw new Exception("Fila vazia! Nenhum cliente para atender.");
        }
        Elemento atendido = frente.dado;
        frente = frente.proximo;
        if (frente == null) tras = null;
        System.out.println("Atendido: " + atendido.nome + " - " + atendido.descricao);
        return atendido;
    }

    // Verificar se a fila está vazia
    public boolean estaVazia() {
        return frente == null;
    }

    // Exibir fila de atendimento
    public void exibir() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
            return;
        }
        System.out.println("\n- FILA DE ATENDIMENTO -");
        Node atual = frente;
        int posicao = 1;
        while (atual != null) {
            System.out.println(posicao + "º -> " + atual.dado.nome + " (" + atual.dado.descricao + ")");
            atual = atual.proximo;
            posicao++;
        }
        System.out.println("----------------------------\n");
    }
}

// Main
public class Main {
    public static void main(String[] args) {
        try {
            // Cria a pilha e fila
            Pilha historico = new Pilha();
            Fila fila = new Fila();

            // Adiciona solicitações (histórico)
            // O campo "nome" não se aplica nesse caso logo ele é definido como "null"
            historico.empilhar(new Elemento("REQ001", null, "Instalação de software", "2024-08-20 10:30"));
            historico.empilhar(new Elemento("REQ002", null, "Manutenção preventiva", "2024-08-20 11:00"));
            historico.empilhar(new Elemento("REQ003", null, "Atualização de sistema", "2024-08-20 11:30"));
            historico.empilhar(new Elemento("REQ004", null, "Suporte técnico", "2024-08-20 12:00"));
            historico.exibir();

            // Remove uma solicitação
            historico.desempilhar();
            historico.exibir();

            // Adiciona clientes (fila)
            // O campo "dataHora" não se aplica nesse caso logo ele é definido como "null"
            fila.enfileirar(new Elemento("CLI001", "Maria Silva", "Dúvida sobre produto", null));
            fila.enfileirar(new Elemento("CLI002", "João Souza", "Reclamação de serviço", null));
            fila.enfileirar(new Elemento("CLI003", "Ana Costa", "Solicitação de reembolso", null));
            fila.exibir();

            // Atende um cliente
            fila.desenfileirar();
            fila.exibir();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
