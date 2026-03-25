import lib.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String[] SIGLAS = {"AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"};
    private static final String[] NOMES = {
        "Alagoas", "Bahia", "Ceará", "Maranhão", "Paraíba",
        "Pernambuco", "Piauí", "Rio Grande do Norte", "Sergipe"
    };

    public static void main(String[] args) {
        String caminhoGrafo = "dados/nordeste.txt";
        String caminhoConsulta = "dados/entrada.txt";

        In inGrafo = new In(caminhoGrafo);
        if (!inGrafo.exists()) {
            System.out.println("Erro: Arquivo '" + caminhoGrafo + "' nao encontrado.");
            return;
        }
        Graph G = new Graph(inGrafo);

        In inConsulta = new In(caminhoConsulta);
        if (!inConsulta.exists()) {
            System.out.println("Erro: Arquivo '" + caminhoConsulta + "' nao encontrado.");
            return;
        }

        String linhaX = inConsulta.readLine(); 
        String linhaY = inConsulta.readLine(); 

        int indexX = getIndexFromSigla(linhaX.split(":")[1].trim());
        int indexY = getIndexFromSigla(linhaY.split(":")[1].trim());

        DepthFirstPaths dfs = new DepthFirstPaths(G, indexX);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, indexX);

        // --- TÍTULO DINÂMICO ---
        System.out.println("====================================================");
        System.out.println("      ANALISE DE ESTADO: " + NOMES[indexX].toUpperCase() + " ATÉ " + NOMES[indexY].toUpperCase());
        System.out.println("====================================================\n");

        // QUESTÃO 01 - Formato Sim/Não direto
        System.out.print("[QUESTÃO 01] Verificação de Caminho RESULTADO: ");
        if (dfs.hasPathTo(indexY)) 
            System.out.println("SIM, existe um caminho terrestre entre " + NOMES[indexX] + " e " + NOMES[indexY] + ".");
        else 
            System.out.println("NÃO, não existe caminho terrestre entre " + NOMES[indexX] + " e " + NOMES[indexY] + ".");
        System.out.println();

        // QUESTÃO 02
        System.out.print("[QUESTÃO 02] Caminho encontrado por DFS (Busca em Profundidade): ");
        imprimirCaminhoFormatado(dfs.pathTo(indexY), " -> ");

        // QUESTÃO 03
        System.out.print("[QUESTÃO 03] Caminho encontrado por BFS (Busca em Largura - Menor Caminho): ");
        imprimirCaminhoFormatado(bfs.pathTo(indexY), " -> ");

        // QUESTÃO 04
        System.out.println("[QUESTÃO 04] Estados alcançáveis a partir da origem (" + NOMES[indexX] + "):");
        System.out.print("Lista: ");
        for (int i = 0; i < G.V(); i++) {
            if (dfs.hasPathTo(i)) System.out.print("[" + NOMES[i] + "] ");
        }
        System.out.println("\n");

        // QUESTÃO 05
        System.out.println("[QUESTÃO 05] Ordem de visita na execução da DFS:");
        imprimirOrdemVisita(dfs.get_aux_visita());

        // QUESTÃO 06
        System.out.println("[QUESTÃO 06] Ordem de visita na execução da BFS:");
        imprimirOrdemVisita(bfs.get_aux_visita());
        
        System.out.println("====================================================");
    }

    private static int getIndexFromSigla(String sigla) {
        for (int i = 0; i < SIGLAS.length; i++) {
            if (SIGLAS[i].equalsIgnoreCase(sigla)) return i;
        }
        return -1;
    }

    private static void imprimirCaminhoFormatado(Iterable<Integer> path, String sep) {
        if (path == null) {
            System.out.println("Nenhum caminho encontrado.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int v : path) {
            if (sb.length() > 0) sb.append(sep);
            sb.append(NOMES[v]);
        }
        System.out.println(sb.toString() + "\n");
    }

    private static void imprimirOrdemVisita(Iterable<Integer> order) {
        if (order == null) {
            System.out.println();
            return;
        }
        for (int v : order) {
            System.out.print(NOMES[v] + " | ");
        }
        System.out.println("\n");
    }
}