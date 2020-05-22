private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    vet = new int[Integer.valueOf(tamVet.getText())];
    ordenado = new int[Integer.valueOf(tamVet.getText())];
    metUtilizado = (String) CBMetodo.getSelectedItem();
    if (CBMetodo.getSelectedItem().equals("Ordenado")) {
        for (int i = 0; i < Integer.valueOf(tamVet.getText()); i++) {
            vet[i] = i;
        }
    } else if (CBMetodo.getSelectedItem().equals("Reverso")) {
        for (int i = 0; i < Integer.valueOf(tamVet.getText()); i++) {
            vet[i] = -i;
        }
    } else if (CBMetodo.getSelectedItem().equals("Aleatório")) {
        Random randomGenerator = new Random();
        for (int i = 0; i < Integer.valueOf(tamVet.getText()); i++) {
            vet[i] = randomGenerator.nextInt(Integer.valueOf(tamVet.getText()));
        }
    }
    vetList.clear();
    new Thread()
    {
        public void run() {
            for (int i = 0; i < vet.length; i++) {
                int N_DIVISOES = vet.length/4;
                vetList.add("[" + i + "] " + String.valueOf(vet[i]));
                PB.setValue((i/N_DIVISOES) * N_DIVISOES); // i want update here
            }
        }
     }.start();
}