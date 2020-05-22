Integer iteracao = null;
try {
    iteracao = Integer.parseInt(iteracoes.getText().toString());
} catch (NumberFormatException e) {
    // TODO: Show a toast to let users know the input value is not valid
}