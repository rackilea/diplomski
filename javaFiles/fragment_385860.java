int j,k;
    boolean flag = true;  // will determine when the sort is finished
    Salesperson person = new Salesperson(null, 0, 0);

    while (flag) {
        flag = false;
        for (j = 0, k=1; j < salesperson.size()-1; j++, k++) {
            if (salesperson.get(j).getName().compareToIgnoreCase(salesperson.get(j+1).getName()) > 0) {                                             // ascending sort

                person = salesperson.get(j);
                salesperson.set(j, salesperson.get(k));     
                salesperson.set(k, person);
                flag = true;
            }
        }
    }