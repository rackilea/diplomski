public static void main(String[] args) {
    String word = "S]RG-M]P";

    char[] a = word.toCharArray();
    for (int i = 1; i < a.length-1; i++) {//@Jon Skeet again is right X2 :)

        //no need now, for loop bound changed
        //if(i+1>a.length){
    //      continue;
    //  }


        if (a[i] == ']') {

            //no need now, for loop bound changed
            //@Jon Skeet you are right, this handles the case :)
            //if(i==0 || i == a.length-1){
                //continue;
            //}

            a[i + 1] = 'r';
            a[i - 1] = 'l';
        }
    }

    String outt = new String(a);
    System.out.print(outt);
}// main