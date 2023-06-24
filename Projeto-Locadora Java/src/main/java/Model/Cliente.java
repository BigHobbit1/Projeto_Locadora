package Model;

public class Cliente {
    private int cpf;
    private String nome;

    public Cliente(String nome,int cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }
}

