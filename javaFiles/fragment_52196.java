int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID para a busca"));
        boolean found = false;

        //'for' para percorrer o vetor
        for (Produto objProduto : vetorProdutos2) {
         //if para verificar se o ID digitado para busca contém no vetor
         if (objProduto.getId() == opcao) {
                     JOptionPane.showMessageDialog(null,
      "\nID: " + objProduto.getId()+"\nDescrição: " + objProduto.getDescricao()
                                                    + "\nEstoque: " + objProduto.getEstoque() + "\nPreço: "
                                                    + objProduto.getPreço() + "\nStatus: " + objProduto.getStatus());
                   found = true;
               } 
         }
 if (! found)
 {
  JOptionPane.showMessageDialog(null, "Produto não encontrado");
}