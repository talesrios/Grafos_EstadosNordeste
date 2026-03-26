# 🗺️ Análise de Conectividade: Região Nordeste
> **Projeto de Teoria dos Grafos** | Engenharia de Computação - 8º Semestre

Este sistema realiza o processamento de caminhos e conectividade entre os 9 estados do Nordeste brasileiro, utilizando as estruturas clássicas de **Busca em Profundidade (DFS)** e **Busca em Largura (BFS)**.

---

## 🛠️ Modificações Técnicas: O Atributo `aux_visita`

A principal inovação técnica deste projeto foi a modificação das classes originais da biblioteca `algs4`. Implementamos o atributo **`aux_visita`** para capturar a cronologia exata dos algoritmos.

* **Problema:** As classes originais apenas informam *se* um estado foi visitado e o *caminho final*.
* **Solução:** O `aux_visita` (uma `List<Integer>`) registra a ordem de entrada de cada vértice durante a execução.
* **Diferença na Execução:**
    * **Na DFS:** Registra a ordem de "mergulho" (recursão).
    * **Na BFS:** Registra a ordem de expansão por camadas (fila).

---

## 📊 Estrutura do Grafo (Mapeamento Alfabético)

O grafo foi modelado com **9 vértices** e **14 arestas**, representando as divisas territoriais reais.

| ID | Estado | Sigla | Conexões Territoriais |
|:--:|:-------|:-----:|:---------------------|
| 0  | Alagoas | AL | BA, PE, SE |
| 1  | Bahia | BA | AL, PE, PI, SE |
| 2  | Ceará | CE | PB, PE, PI, RN |
| 3  | Maranhão | MA | PI |
| 4  | Paraíba | PB | CE, PE, RN |
| 5  | Pernambuco | PE | AL, BA, CE, PB, PI |
| 6  | Piauí | PI | BA, CE, MA, PE |
| 7  | Rio Grande do Norte | RN | CE, PB |
| 8  | Sergipe | SE | AL, BA |

---

## 🚀 Como Executar

O programa está configurado para leitura automática de arquivos na pasta `dados/`.

1.  **Arquivos de Entrada:**
    * `dados/nordeste.txt`: Estrutura do grafo (V e E).
    * `dados/consulta.txt`: Define a Origem (X) e o Destino (Y).
2.  **Execução via VS Code:**
    * Abra a classe `App.java` e clique no botão **Run**.
    * Certifique-se de que a pasta `dados` está na raiz do diretório aberto.

---

## 📝 Questões Avaliadas no Relatório

| Questão | Descrição | Objetivo Técnico |
|:---:|:---|:---|
| **01** | **Alcançabilidade** | Validar se existe conexão terrestre entre X e Y. |
| **02** | **Caminho DFS** | Mostrar a rota baseada em profundidade (Pilha). |
| **03** | **Caminho BFS** | Encontrar o **menor caminho** (Shortest Path). |
| **04** | **Estados Alcançáveis** | Listar todos os estados acessíveis a partir da origem. |
| **05** | **Ordem DFS** | Exibir a cronologia via `aux_visita` (Recursão). |
| **06** | **Ordem BFS** | Exibir a cronologia via `aux_visita` (Fila). |

---

## Link do vídeo da apresentação
Link: https://drive.google.com/drive/folders/1A7jYakMTq-wYoHGJbEItcULdi6WQSK7q?usp=sharing
