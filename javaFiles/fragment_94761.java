while (moreRecords) {
        Employee rec = Main.getData();

        try ( ObjectOutputStream dos =
                     new ObjectOutputStream(
                             new FileOutputStream(file) ) ) {

            dos.writeObject(rec);

        }

        System.out.printf("Add more records [true/false]? ");
        moreRecords = scanner.nextBoolean();
    }