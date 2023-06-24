package Model;
import DAO.ClienteDAO;
import DAO.VeiculoDAO;

public class Supervisor extends Sistema{
    private String nome;
    private int ssn_sup;
    VeiculoDAO veiculoDAOS = new VeiculoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    public Supervisor(String email, String senha) {
        super(email, senha);
    }

    public void pesquisaTotal(){
        veiculoDAOS.pesquisaTotal();
    }

    public void retirarVeiculo(Veiculo veiculo){
        System.out.println("Deletando o veiculo do sistema");
        veiculoDAOS.deleteUser(veiculo);
    }

    public void retirarCliente(int cpf){
        System.out.println("Cliente retirado do sistema");
        clienteDAO.deleteUser(cpf);
    }

    public String getNome() {
        return nome;
    }

    public int getSsn_sup() {
        return ssn_sup;
    }
}
