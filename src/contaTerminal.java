import java.util.Scanner;

public class contaTerminal {
    public static void main(String[] args) {
        //TODO: conhecer e importar a classe Scanner;
        // exibir as mensagens para o usuário;
        // obter pela classe Scanner os valores digitados no terminal;
        // exibir a mensagem da conta criada.

        int numeroConta;
        String contaFormatada;
        String agencia;
        String entradaAgencia;
        String agenciaFormatada;
        String nomeCliente;
        String contaStr;
        double saldo;
        Scanner scan = new Scanner(System.in);

        // Número da conta
        while (true) {
            System.out.println("Informe o número da conta: ");
            contaStr = scan.nextLine().trim();

            // Exclui caracteres não numéricos e limita o campo a 6 caracteres numéricos
            if (contaStr.contains("-")) {
                System.out.println("o número da conta não pode conter símbolos");
            } else if (!contaStr.matches("[0-9]+")) {
                System.out.println("O número deve conter apenas algarismos.");
            } else if(contaStr.length() != 6) {
                    System.out.println("O número deve conter 6 algarismos");
            } else {
                numeroConta = Integer.parseInt(contaStr);
                int parte1 = numeroConta / 10;
                int parte2 = numeroConta % 10;
                contaFormatada = parte1 + "-" + parte2;
                break;
            }
        }

        // Agência
        while (true) {
            System.out.println("Informe a agência: ");
            entradaAgencia = scan.nextLine().trim();

            // Verifica se é número negativo (hífen na posição 0 da string)
            if (entradaAgencia.matches("-\\d+")) {
                System.out.println("O número da agência não pode ser negativo.");
                continue;
            }

            // Verifica se contém apenas dígitos
            if (!entradaAgencia.matches("\\d+")) {
                System.out.println("O campo Agência deve conter apenas algarismos.");
                continue;
            }

            if (entradaAgencia.length() > 5) {
                System.out.println("O campo Agência não pode exceder 5 dígitos.");
            } else if (entradaAgencia.length() < 5) {
                System.out.println("O campo Agência não pode ter menos de 5 dígitos.");
            } else {
                agencia = entradaAgencia;
                // Acrescenta hífen antes do último dígito
                agenciaFormatada = agencia.substring(0, 4) + "-" + agencia.charAt(4);
                break;
            }
        }

        // Nome do cliente
        while (true) {
            System.out.println("Informe o nome do cliente: ");
            nomeCliente = scan.nextLine().trim();

            if(nomeCliente.isEmpty()) {
                System.out.println("O campo 'nome' não pode estar vazio");
            } else if(nomeCliente.length() > 100) {
                    System.out.println("O nome não pode exceder 100 caracteres.");
            } if (!nomeCliente.matches("[a-zA-ZÀ-ÿ\\s'’\\-]+")) {
                System.out.println("O nome deve conter apenas letras, espaços, hífens ou apóstrofos.");
            } else {
                break;
            }
        }

        // Saldo
        while (true) {
            System.out.println("Informe o saldo: ");

            try {
                saldo = Double.parseDouble(scan.nextLine());
                if (saldo < 0) {
                    System.out.println("O saldo não pode ficar negativo, mas você pode fazer um depósito.");
                } else {
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }

        // Visualização dos dados solicitados
        System.out.printf("Olá, %s! Obrigado por criar uma conta em nosso banco, " +
                "sua agência é %s, conta %s e seu saldo %.2f " +
                "já está disponível para saque.\n", nomeCliente, agenciaFormatada, contaFormatada, saldo);
    }
}