while(fileReader.hasNext()) {
        String line = fileReader.nextLine();
        String[] splitText = line.split("\\s*-\\s*");

        for (String field : splitText) {
            System.out.println(field);
        }
    }