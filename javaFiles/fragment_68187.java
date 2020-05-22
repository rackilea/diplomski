Scanner queries = new Scanner(new FileReader("./out.txt"));
        int index1 = 0;
        while ( queries.hasNextLine() ){
            String check = queries.next();
            Reader r = new FileReader("./tal.txt");
            try {
                Scanner folks = new Scanner(r);
                while (folks.hasNextLine()) {
                    String toCheck = folks.next();
                    index1 = toCheck.indexOf(check);
                    if (index1 >= 0) {
                        // Do something with index1 here?
                    }
                }//while
            } finally {
                r.close();
            }
        }//while