private void configurarTabela() {
    colunaCodigo.setCellValueFactory(new MultiPropertyValueFactory<ItemBean,String>("produto.id"));
    colunaDescricao.setCellValueFactory(new MultiPropertyValueFactory<ItemBean,String>("produto.descricao"));
    colunaLinha.setCellValueFactory(new MultiPropertyValueFactory<ItemBean,String>("produto.nomeLinha"));
    .....
}