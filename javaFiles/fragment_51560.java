private void adicionarProcessadorEventoEnterPressionado(Node elemento) {
    if(elemento instanceof Pane){
        Pane painel= (Pane) elemento;
        for(Node filho :painel.getChildren()){
            if(filho instanceof TextField || filho instanceof ComboBox || filho instanceof CheckBox
                    || filho instanceof DatePicker || filho instanceof BigDecimalField)
                filho.addEventFilter(KeyEvent.KEY_PRESSED,processadorEnterEmCampo);
            else if(filho instanceof Button)
                filho.setOnKeyPressed(processadorEnterEmBotao);
            else
                adicionarProcessadorEventoEnterPressionado(filho);
        }
    }
}