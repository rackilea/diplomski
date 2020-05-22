private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

    Vector vetColuna = new Vector();
    Vector vetLinhas = new Vector();
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(str_conn, usuario, senha);
        stmt = con.createStatement();
        sql = "select topico, nota, datanota from notas where notas.cod_aluno =" + jTextField1.getText() + " and notas.cod_curso =" + jTextField2.getText() + " order by notas.datanota";
        rs = stmt.executeQuery(sql);
        if (rs == null) {
            return;
        }
        ResultSetMetaData rsmd;
        rsmd = rs.getMetaData();
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            vetColuna.add(rsmd.getColumnLabel(i + 1));
        }

        while (rs.next()) {
            Vector vetLinha = new Vector();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                vetLinha.add(rs.getObject(i + 1));
            }
            vetLinhas.add(vetLinha);
        }
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Erro\nNão foi possível carregar o driver.");
        System.out.println("Nao foi possivel carregar o driver");
        ex.printStackTrace();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro\nCertifique-se de que todos os\ncampos estejam preenchidos corretamente.");
        System.out.println("Problema com o SQL");
        ex.printStackTrace();
    }

    MessageFormat header = new MessageFormat("Ficha Pedagógica - " + jComboBox1.getSelectedItem() + "\nNome do Aluno - " + jTextField1.getText());

    DefaultTableModel dtm = new DefaultTableModel(vetLinhas, vetColuna);
    JTable jTable2 = new JTable(dtm) {
        @Override
        public Printable getPrintable(PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat) {
            return new TablePrintable(this, printMode, headerFormat, footerFormat);
        }
    };
    try {
        jTable2.setSize(jTable2.getPreferredSize());
        JTableHeader tableHeader = jTable2.getTableHeader();
        tableHeader.setSize(tableHeader.getPreferredSize());
        jTable2.print(JTable.PrintMode.FIT_WIDTH);
    } catch (PrinterException ex) {
        ex.printStackTrace();
    }

}