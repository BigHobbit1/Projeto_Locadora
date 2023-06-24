package DAO;
import Model.Cliente;
import Model.Veiculo;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertVeiculo(Veiculo user) {

        connectToDB();

        String sql = "INSERT INTO veiculo (placa,modelo,cor,devolvido,Cliente_idCliente) values(?,?,?,?,1)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getPlaca());
            pst.setString(2, user.getModelo());
            pst.setString(3, user.getCor());
            pst.setBoolean(4, user.isDevolvido());
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

    //UPDATE status devolvido
    public boolean updateDevolvido(Veiculo user) {
        connectToDB();
        String sql = "UPDATE veiculo SET devolvido=?,Cliente_idCliente=1 where placa=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setBoolean(1, user.isDevolvido());
            pst.setString(2,user.getPlaca());
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

    //Vincula o carro ao cliente
    public boolean updateNDevolvido(Veiculo user, Cliente cliente) {
        connectToDB();
        String sql = "UPDATE veiculo SET devolvido=?,Cliente_idCliente=? where placa=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setBoolean(1, user.isDevolvido());
            pst.setInt(2, cliente.getCpf());
            pst.setString(3,user.getPlaca());
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

    //DELETE
    public boolean deleteUser(Veiculo user) {
        connectToDB();
        String sql = "DELETE FROM veiculo where placa=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getPlaca());
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
    public ArrayList<Veiculo> pesquisaTotal() {
        ArrayList<Veiculo> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM veiculo";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de veiculos: ");

            while (rs.next()) {
                Veiculo userAux = new Veiculo(rs.getString("placa"),rs.getString("modelo"),rs.getString("cor"),rs.getBoolean("devolvido"));

                System.out.println("placa = " + userAux.getPlaca());
                System.out.println("modelo = " + userAux.getModelo());
                System.out.println("cor = " + userAux.getCor());
                if(userAux.isDevolvido()==false) {
                    System.out.println("Nao foi devolvido");
                }
                else
                    System.out.println("Foi devolvido");

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

    public ArrayList<Veiculo> pesquisaDisponiveis() {
        ArrayList<Veiculo> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM veiculo Where Cliente_idCliente=1";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de veiculos disponiveis: ");

            while (rs.next()) {
                Veiculo userAux = new Veiculo(rs.getString("placa"),rs.getString("modelo"),rs.getString("cor"),rs.getBoolean("devolvido"));

                System.out.println("placa = " + userAux.getPlaca());
                System.out.println("modelo = " + userAux.getModelo());
                System.out.println("cor = " + userAux.getCor());
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

