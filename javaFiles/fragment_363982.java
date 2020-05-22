public class LivroView extends JFrame implements ActionListener {

    private JTable tblLivros;
    DefaultTableModel modeloTabela;
    private List<Livro> encontrados;

    public LivroView() {
        super("Manutenção de Livros");

        encontrados = new ArrayList<Livro>();


        modeloTabela = new DefaultTableModel(
            new String[] {
                "Tombo", "Título", "Título Internacional", "Edição", "Autor", "Editora"
            }, 0);


        tblLivros = new JTable(modeloTabela);
        tblLivros.getColumnModel().getColumn(0).setPreferredWidth(54);
        tblLivros.getColumnModel().getColumn(1).setPreferredWidth(104);
        tblLivros.getColumnModel().getColumn(2).setPreferredWidth(136);
        tblLivros.getColumnModel().getColumn(4).setPreferredWidth(102);

        painelTabela = new JScrollPane(tblLivros);
        painelTabela.setVisible(false);

        painelPrincipal.add(painelGeral, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        painelPrincipal.add(painelTabela, BorderLayout.SOUTH);


        //this.setSize(500,300);
        this.setContentPane(painelPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();
        LivroControl control = new LivroControl();
        if ("Adicionar".equalsIgnoreCase(cmd)){


        }
        else if("Excluir".equalsIgnoreCase(cmd)){

        }
        else if("Pesquisar".equalsIgnoreCase(cmd)){
            if (!txtTombo.getText().equals("")){
                Livro l = control.pesquisarLivroPorTombo(txtTombo.getText());
                if (l!=null){
                    txtIdLivro.setText(String.valueOf(l.getIdLivro()));
                    txtTombo.setText(l.getTombo());
                    txtTitulo.setText(l.getTitulo());
                    txtTituloInternacional.setText(l.getTituloInternacional());
                    txtEdicao.setText(l.getEdicao());
                    txtEditora.setText(l.getEditora());
                    txtAutor.setText(l.getAutor());

                }
            }
            else if (!txtAutor.getText().equals("")){
                encontrados = control.pesquisarLivroPorAutor(txtAutor.getText());

                if (encontrados!= null){
                    for (Livro dados : encontrados){

                        Object[] row = new Object[6];

                        row[0] = dados.getTombo();
                        row[1] = dados.getTitulo();
                        row[2] = dados.getTituloInternacional();
                        row[3] = dados.getEdicao();
                        row[4]= dados.getAutor();
                        row[5]= dados.getEditora();

                        modeloTabela.addRow(row);


                    }

                    painelTabela.setVisible(true);

                    painelPrincipal.repaint();
                    this.pack();
                }
            }
            else {
                //the same
            }

        }
    }
    public static void main(String[] args) {
        new LivroView();
    }
}