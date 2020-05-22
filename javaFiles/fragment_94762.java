while (moreRecords) {
        Employee rec = Main.getData();

        ObjectOutputStream dos = null;
        try {
            dos = new ObjectOutputStream(
                            new FileOutputStream(file) );
            dos.writeObject(rec);

        } finally {
           if ( dos!=null  ) {
                dos.close();
           }
        }

        System.out.printf("Add more records [true/false]? ");
        moreRecords = scanner.nextBoolean();
    }