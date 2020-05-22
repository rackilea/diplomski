public void Inserisci(int dim) {
    System.out.print("How many numbers do you want to insert? ");
    dim = input.nextInt();
    if (dim > DIMENSIONE_MAX || dim < 0) {
       // handle this. it can't happen
    } else {
        int i;
        for (i = 0; i < dim; i++) {
            System.out.print("Number for position [" + i + "]:");
            numeri[i] = input.nextInt();
        }
    }
 }