import Model.Funcionario;
import Model.Supervisor;
import Model.Veiculo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Funcionarios ja cadastrados:
        Funcionario f1 = new Funcionario("Jeferso@localiza.br","29412");
        //Supervisor cadastrado
        Supervisor sup1 = new Supervisor("eduardo@localiza.br","12345");
        //Veiculos cadastrados
        Veiculo v1 = new Veiculo("AFD1213","BMW","azul",true);
        Veiculo v2 = new Veiculo("ADS312","Gol","vermelho",false);

        System.out.println("Bem vindo ao sistema!!!");
        System.out.println("Os emails cadastrados são: ");
        System.out.println("1-Jeferson@localiza.br");
        System.out.println("2-eduardo@localiza.br");
        System.out.println("Caso o usuario queira sair do sistema basta digitar algum numero nao registrado");
        int opcao = scanner.nextInt();
        if(opcao==1){
            System.out.println("Digite a senha: ");
            String senha = scanner.next();
            if(f1.verificaSenha(senha)==true){
                System.out.println("Bem vindo Atendente!!!");
                System.out.println("Qual das seguintes opcoes o senhor gostaria");
                System.out.println("1 - adicionar um cliente ao sistema");
                System.out.println("2 - validar a devolucao do carro");
                System.out.println("3 - pesquisar os veiculos disponiveis para alugar no sistema");
                System.out.println("4 - sair da operacao");
                int opcao2 = scanner.nextInt();
                while(opcao2!=4){
                    if(opcao2==1) {
                        System.out.println("Digite o nome do cliente");
                        String nomeC = scanner.next();
                        System.out.println("Digite o cpf do cliente");
                        int cpfC = scanner.nextInt();
                        f1.addCliente(nomeC,cpfC);
                        System.out.println("Cliente adicionado ao sistema");
                    }
                    if(opcao2==2){
                        System.out.println("Qual carro deseja devolver?");
                        System.out.println("1 - Placa:AFD1213");
                        System.out.println("2 - Placa:ADS312");
                        int opcao3 = scanner.nextInt();
                        if(opcao3==1){
                            if(v1.isDevolvido()==true)
                                System.out.println("Veiculo ja devolvido");
                            else {
                                v1.setDevolvido(true);
                                f1.devolucao(v1);
                            }
                        }
                        if(opcao3==2){
                            if(v2.isDevolvido()==true)
                                System.out.println("Veiculo ja devolvido");
                            else{
                                v2.setDevolvido(true);
                                f1.devolucao(v2);
                            }
                        }
                        else
                            System.out.println("Nenhum veiculo cadastrado");
                    }
                    if(opcao2==3){
                        f1.pesquisarVeiculosD();
                    }
                    System.out.println("1 - adicionar um cliente ao sistema");
                    System.out.println("2 - validar a devolucao do carro");
                    System.out.println("3 - pesquisar os veiculos disponiveis para alugar no sistema");
                    System.out.println("4 - sair da operacao");
                    opcao2 = scanner.nextInt();

                }
                System.out.println("Encerrando o sistema");
            }
            else
                System.out.println("O sistema se encerrara por motivos de seguranca");
        }
        if(opcao==2){
            System.out.println("Digite a senha: ");
            String senha = scanner.next();
            if(sup1.verificaSenha(senha)==true){
                System.out.println("Bem vindo supervisor!!!");
                System.out.println("Qual das seguintes opcoes o senhor gostaria");
                System.out.println("1 - Remover veiculo do sistema");
                System.out.println("2 - Remover Cliente do sistema");
                System.out.println("3 - pesquisa de todos os veiculos");
                System.out.println("4 - sair do sistema");
                int opcao2 = scanner.nextInt();
                while(opcao2!=4){
                    if(opcao2==1){
                        System.out.println("Qual carro deseja remover?");
                        System.out.println("1 - Placa:AFD1213");
                        System.out.println("2 - Placa:ADS312");
                        int opcao3 = scanner.nextInt();
                        if(opcao3==1){
                            sup1.retirarVeiculo(v1);
                        }
                        if(opcao3==2){
                            sup1.retirarVeiculo(v2);
                        }
                        else {
                            System.out.println("Veiculo não cadastrado no sistema");
                        }
                    }
                    if(opcao2==2){
                        System.out.println("Digite o cpf do cliente que vc deseja remover:");
                        int cpf = scanner.nextInt();
                        sup1.retirarCliente(cpf);
                    }
                    if(opcao2==3){
                        sup1.pesquisaTotal();
                    }
                    System.out.println("1 - Remover veiculo do sistema");
                    System.out.println("2 - Remover Cliente do sistema");
                    System.out.println("3 - pesquisa de todos os veiculos");
                    System.out.println("4 - sair do sistema");
                    opcao2 = scanner.nextInt();
                }
                System.out.println("Encerrando o sistema");
            }
            else
                System.out.println("O sistema se encerrara por motivos de seguranca");
        }
    }
}