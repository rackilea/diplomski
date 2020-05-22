public boolean departure(String r, char t) {
        int counter = 0;
        boolean status = false;
        do {
            c1 = g1.pop();
            if (c1.regis.equals(r) == false) {
                np1.enqueue(c1.regis, 'a');
                counter++;
            } else if (c1.regis.equals(r) == true) {
                while (np1.isEmpty() != true) {
                    c2 = np1.dequeue();
                    g1.push(c2.regis, c2.status);
                }
                status = true;
                counter = g1.checkSpace();
            } else {
                status = false;
            }
        } while (counter < g1.checkSpace());
        return status;
    }