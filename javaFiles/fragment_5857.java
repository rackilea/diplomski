private void jbInit() throws Exception {
    ...
    jScrollPane1.getViewport().add(jTable1, null);
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(jScrollPane1, null);
    jTable1 = new JTable (model);
    ...