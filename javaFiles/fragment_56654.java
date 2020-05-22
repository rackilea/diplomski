private void replace(String misspelled, String replacement){
         int i = 0;
         for(String line: fileLine) {
            if(line.contains(misspelled)) {
                line.replaceAll(misspelled, replacement);
                System.out.println("replaced word" + misspelled  + "in line number" + i );
                i++;
            }else i++;
         }
    }