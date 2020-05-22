for (int i=0; i<text.length(); i++){

        if (letter==text.charAt(i) || (letter+32)==text.charAt(i)){
        count++;
        }

            if (count>0){
                System.out.println(letter+" = "+count);
            }
    }