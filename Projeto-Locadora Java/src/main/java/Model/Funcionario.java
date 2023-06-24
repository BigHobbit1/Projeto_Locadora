package Model;
import DAO.ClienteDAO;
import DAO.VeiculoDAO;

public class Funcionario extends Sistema implements Comandos{
    private String nome;
    private int cpf;
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();

    public Funcionario(String email, String senha) {
        super(email, senha);
    }


    @Override
    public void pesquisarVeiculosD() {
        veiculoDAO.pesquisaDisponiveis();
    }

    @Override
    public void devolucao(Veiculo veiculos) {
        veiculos.setDevolvido(true);
        veiculoDAO.updateDevolvido(veiculos);
    }

    //Adiciona clientes ao sistema
    @Override
    public void addCliente(String nome, int cpf) {
        System.out.println("Adicionando o cliente ao sistema");
        Cliente c = new Cliente(nome,cpf);
        clienteDAO.insertUser(c);
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }
}

