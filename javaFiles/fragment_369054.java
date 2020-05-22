//Conversion of String to Character Array//

    String s = word.toUpperCase();
    char[] tempArr = s.toCharArray();
    Character[] arr = new Character[tempArr.length];




    for (int i=0,j=0 ; i<tempArr.length ; i++,j++){

        arr[i] = tempArr[j];
    }


    for (Character c : l){

             tempL.add(c);



    }


    Log.d("Vivek-Characters",tempL.toString());
    }