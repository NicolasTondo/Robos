import java.util.*;

public class teste {

    public static int calcularRodadas(int[] receita) {
        int n = receita.length;
        int[] estadoAtual = new int[n];
        for (int i = 0; i < n; i++) {
            estadoAtual[i] = i;
        }

        Set<String> configuracoesVistas = new HashSet<>();
        configuracoesVistas.add(Arrays.toString(estadoAtual));

        int rodadas = 0;

        while (true) {
            rodadas++;

            int[] proximoEstado = new int[n];
            for (int i = 0; i < n; i++) {
                proximoEstado[i] = estadoAtual[receita[i]];
            }

            String config = Arrays.toString(proximoEstado);
            if (configuracoesVistas.contains(config)) {
                break;
            }

            configuracoesVistas.add(config);
            estadoAtual = proximoEstado;
        }

        return rodadas;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Digite o número de robôs: ");
        int n = sc.nextInt();

        int[] receita = new int[n];
        for (int i = 0; i < n; i++) {
            receita[i] = random.nextInt(n);
        }

        System.out.println("Receita de dança gerada automaticamente: " + Arrays.toString(receita));

        int rodadas = calcularRodadas(receita);
        System.out.println("Número de rodadas até repetição: " + rodadas);

        sc.close();
    }
}
