String[] header;
        String[] row;
        int index = 0;
        // processing the header;
        header = reader.readNext();
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals("Card Text Listen")) {
                index = i;
                break;
            }
        }
        // processing data
        while ((row = reader.readNext()) != null) {
            for (int i = 0; i < row.length; i++) {
                if (index == i) {
                    row[i] = "new value";
                    break;
                }
            }
            writer.writeNext(row);
        }