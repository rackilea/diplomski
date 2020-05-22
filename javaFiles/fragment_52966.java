import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TelaListaDoc extends JPanel {

    private DefaultTableModel modelLivro;
    private DefaultTableModel modelRevista;
    private JTable table;

    public TelaListaDoc(Biblioteca biblio) {

        this.biblioteca = biblio;
        this.inicializado = false;

        setLayout(new BorderLayout());

        panelMain = new JPanel();

        String[] nomes = {"Título", "Nº disponíveis", "Código"};
        modelLivro = new DefaultTableModel(nomes, 0);
        modelRevista = new DefaultTableModel(nomes, 0);

        table = new JTable(modelLivro);

        botaoVoltar = new JButton("Voltar");
        botaoRevista = new JButton("Revistas");
        botaoLivro = new JButton("Livros");

        panelMain.add(new JTable(model));
        panelMain.add(panelTable);
        panelMain.add(botaoVoltar);

        add(panelMain);

        botaoVoltar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                biblioteca.chamaTelaBiblioteca();
            }
        });

        botaoLivro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                table.setModel(modelLivro);
            }
        });

        botaoRevista.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                table.setModel(modelRevista);
            }
        });
    }

    public void listar(ArrayList<String[]> livros, ArrayList<String[]> revistas) {
        if (!this.inicializado) {  //If not initialized, only doing it once.

            this.livros = livros;
            this.revistas = revistas;
            for (String[] livro : this.livros) {
                modelLivro.addRow(livro);
            }
            for (String[] revista : this.revistas) {
                modelRevista.addRow(revista);
            }
            this.inicializado = true;

            table.setModel(modelRevista);
        }

    }

}