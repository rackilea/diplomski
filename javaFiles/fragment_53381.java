public void finalizar() {
    ArrayList<ItemAdubacao> itensIguaisArrayList;
    itensIguaisArrayList = new ArrayList<>();
    adubacaoArrayList = new ArrayList<>();

    for (ItemAdubacao itemAdubacao : itemAdubacaoArrayList) {
        if (!itensIguaisArrayList.contains(itemAdubacao)) {
            itensIguaisArrayList.add(itemAdubacao);
        }
    }
    for (int i = 0; i < itensIguaisArrayList.size(); i++) {
        float soma = 0;
        for (ItemAdubacao linha : itemAdubacaoArrayList) {
            if (linha.equals(itensIguaisArrayList.get(i))) {
                soma += linha.getQuantidadeProduto();
            }
        }
        itensIguaisArrayList.get(i).setQuantidadeProduto(soma);
    }
}