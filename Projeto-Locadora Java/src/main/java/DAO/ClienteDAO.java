package DAO;
import Model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertUser(Cliente user) {

        connectToDB();

        String sql = "INSERT INTO cliente (Clicpf,nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, user.getCpf());
            pst.setString(2, user.getNome());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //DELETE
    public boolean deleteUser(int cpf) {
        connectToDB();
        String sql = "DELETE FROM cliente where Clicpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cpf);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //SELECT
    public ArrayList<Cliente> selectUser() {
        ArrayList<Cliente> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM cliente";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de clientes: ");

            while (rs.next()) {

                Cliente userAux = new Cliente(rs.getString("nome"),rs.getInt("cpf"));

                System.out.println("nome = " + userAux.getNome());
                System.out.println("cpf = " + userAux.getCpf());
                System.out.println("--------------------------------");

                users.add(userAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return users;
    }
}

