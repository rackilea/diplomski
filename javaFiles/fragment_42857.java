String myString = "Copying first N numbers of words to a string";
    String [] arr = myString.split("\\s+"); 
         //Splits words & assign to the arr[]  ex : arr[0] -> Copying ,arr[1] -> first


        int N=3; // NUMBER OF WORDS THAT YOU NEED
        String nWords="";

        // concatenating number of words that you required
        for(int i=0; i<N ; i++){
             nWords = nWords + " " + arr[i] ;         
        }

    System.out.println(nWords);