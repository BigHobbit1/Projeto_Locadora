package Model;

public class Veiculo {
    private String placa;
    private String modelo;
    private String cor;
    private boolean devolvido;

    public Veiculo(String placa,String modelo,String cor,boolean devolvido) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.devolvido = devolvido;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
