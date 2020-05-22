public int getSpinnerIndex(Spinner spinner, String myString) {
    int index = 0;

    for (int i = 0; i < spinner.getCount(); i++) {
        HMAuxCartao model = hmAux.get(i);
        String modelS = model.get(CartaoDao.IDCARTAO);
        if (modelS != null) {
            if (modelS.equals(myString)) {
                index = i;
            }
        }
    }
    return index;
}