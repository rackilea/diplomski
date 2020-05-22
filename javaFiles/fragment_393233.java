int dicLength = dictionary.length;

    for (String[] row : inputEntries) {
        for(int i = 0; i < dicLength; i++) {

            String rowEntry = row[1].toLowerCase();
            String dictionaryTerm = dictionary[i].toLowerCase();

            if(rowEntry.contains(dictionaryTerm)) {
                String entries = row[0] + "," + row[1] + "," + "";
                String[] output = entries.split(",");
                writer.writeNext(output);
                System.out.println(output + ": This contained a Dictionary word");
                break;
            }

            if (i == (dicLength - 1)) {
                String entries = row[0] + "," + "" + "," + row[1];
                String[] output = entries.split(",");
                writer.writeNext(output);
                System.out.println(output + ": This did not contain a Dictionary word");
            }
        }
    }