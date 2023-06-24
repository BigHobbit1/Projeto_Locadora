package Model;

public abstract class Sistema {
    private String email;
    private String senha;

    public Sistema(String email,String senha) {
        this.email = email;
        this.senha = senha;
    }

    public boolean verificaSenha(String senha){
        if (this.senha.equals(senha)) {
            System.out.println("Logado com sucesso");
            return true;
        } else {
            System.out.println("O email está incorreto! Digite novamente. ");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }
}