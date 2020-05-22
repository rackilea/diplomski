import java.io.FileNotFoundException;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.PolarPoint;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class Main {

    /**
     * 
     * @param args
     * @throws IOException
     * 
     */

    // BEGIN DEEP SEARCH

    Stack<Word> pilha;

    public void buscaProfundidade(Graph<Word, Relacao> g1, Word n0) {
        HashMap<Integer, Word> visitados = new HashMap<Integer, Word>();
        pilha = new Stack<Word>();
        pilha.add(n0);
        while (!pilha.isEmpty()) {
            Word n = pilha.pop();
            marcarVisitado(n, visitados);
            processarNo(n); // print
            Collection<Word> adjacencias = g1.getNeighbors(n); // coleção dos
                                                                // adjacentes do nó
                                                                // atual
            for (Word adjacente : adjacencias) {
                if (!foiVisitado(adjacente, visitados)) {
                    pilha.push(adjacente);
                }
            }
        }
        // RENDERIZA GRAFO
        Layout<Word, Relacao> layout = new CircleLayout<Word, Relacao>(g1);
        layout.setSize(new Dimension(800, 600)); // sets the initial size of the
                                                    // space
        // The BasicVisualizationServer<V,E> is parameterized by the edge types
        BasicVisualizationServer<Word, Relacao> vv = new BasicVisualizationServer<Word, Relacao>(layout);

        vv.setPreferredSize(new Dimension(800, 600)); // Sets the viewing area
                                                        // size
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setLabelOffset(20);

        JFrame frame = new JFrame("WORD INDICATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }

    private void processarNo(Word n) {
        System.out.println(n);

    }

    boolean foiVisitado(Word adjacente, HashMap<Integer, Word> visitados) {

        return visitados.containsKey(adjacente.getId());

    }

    private void marcarVisitado(Word n, HashMap<Integer, Word> visitados) {
        visitados.put(n.getId(), n);

    }

    // DEEP SEARCH END
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        Scanner scan = null;

        Stack<Word> words = new Stack<Word>();
        // CRIA GRAFO
        // Read txt

        try {
            scan = new Scanner(
                    new File("C:\\Users\\Auryon.AURYON-PC\\Documents\\GitHub\\java-works\\Graphs_JUNG\\teste.txt"));

            // scan = new Scanner(new
            // File("C:\\Users\\Auryon.AURYON-PC\\Desktop\\flatWiki.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Graph<Word, Relacao> g = new SparseMultigraph<Word, Relacao>();
        int i = 1;
        Relacao word_type = new Relacao("connect");
        String s = scan.next();
        Word word = new Word(i, s, s, s, s);
        words.push(word);
        g.addVertex(word);

        while (scan.hasNextLine()) {
            i++;
            s = scan.next(); // TODO:implementar classes separadas
            /*
             * s2 s3 s4
             */
            word = new Word(i, s, s, s, s);
            g.addVertex(word);
            try {
                word_type = new Relacao("");
                g.addEdge(word_type, words.lastElement(), word, EdgeType.DIRECTED);
                words.push(word);

            } catch (Exception e) {

            }
            ;

            System.out.println(g);
            System.out.println(words.size());
        }

        Main busca = new Main();
        Collection<Word> vertices = g.getVertices();
        Word p = vertices.iterator().next(); // parametro busca
        busca.buscaProfundidade(g, p);

        // TERMINA GRAFO

    }

}