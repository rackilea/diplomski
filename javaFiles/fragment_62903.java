while (scannerFile.hasNext()) {
        String character = scannerFile.next();
        int index =0;
        char star = '*';
        while(index<character.length()) {

            if(character.charAt(index)==star){
                starNumber++;
            }
            index++;
        }
        /* PRINTS the result for each line!!! */
        System.out.println(starNumber);
    }