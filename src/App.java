import lib.*;

/*
-----------------------------------------
LEGENDA DO GRAFO - CAPITAIS DO NORDESTE
-----------------------------------------
ID | ESTADO
-- | ------
0  | MA
1  | PI
2  | CE
3  | RN
4  | PB
5  | PE
6  | AL
7  | SE
8  | BA

*/

public class App { 
    public static void main(String[] args) { 
        // 1. Carrega o Grafo
        In in = new In("dados/nordeste.txt");
        Graph G = new Graph(in);
        String[] nomes = {"São Luís", "Teresina", "Fortaleza", "Natal", "João Pessoa", "Recife", "Maceió", "Aracaju", "Salvador"};

        // 2. Define X (Origem) e Y (Destino)
        int X = 2; 
        int Y = 8; 

        // 3. Cria o objeto BFS
        BreadthFirstPaths bfsX = new BreadthFirstPaths(G, X);

        // 4. Chama a função da Questão 01
        Alcancabilidade(bfsX, nomes, Y);
        
    } 

    
    public static void Alcancabilidade(BreadthFirstPaths bfs, String[] nomes, int destino) {
        System.out.println("\n[QUESTÃO 01] Verificação de Caminho");
        
        if (bfs.hasPathTo(destino)) {
            System.out.println("RESULTADO: SIM, existe um caminho até " + nomes[destino] + ".");
        } else {
            System.out.println("RESULTADO: NÃO, o estado " + nomes[destino] + " não é alcançável por terra.");
        }
    }
} 