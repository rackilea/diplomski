public Dictionary(int size) {
        //noinspection unchecked
        table = new ArrayList[size];

        newDictionary();
    }

    public void newDictionary() {
        for (int i = 0; i < table.length ; i++) {
            table[i] = new ArrayList<List<String>>(99);

            for ( int j = 0; j < 99; j++ ) {
                table[i].add(new ArrayList<String>());
            }
        }
    }