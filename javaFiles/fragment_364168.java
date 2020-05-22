public T_Jogo(Jogador jogador, LivroTeste livroTeste) {
    this.livroTeste = livroTeste;
    initComponents();

    //Centraliza janela e desabilita botão maximizar
    this.setResizable(false);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    jTextArea1.setEditable(false);
    jTextArea1.setLineWrap(true);

    jButton1.setActionCommand("jButton1");
    jButton1.addActionListener(livroTeste);

    jButton2.setActionCommand("jButton2");
    jButton2.addActionListener(livroTeste);

    jButton3.setActionCommand("jButton3");
    jButton3.addActionListener(livroTeste);

    jButton4.setActionCommand("jButton4");
    jButton4.addActionListener(livroTeste); 

    jLabel1.setText(jogador.getNome());
    jLabel5.setText(Integer.toString(jogador.getVida()));
    jLabel6.setText(Integer.toString(jogador.getAtaque()));
    jLabel7.setText(Integer.toString(jogador.getPericia()));
}