public class LexicographicalOrder {
        public static void main(String args[]){

            String[] mystr = {"Jack","Fortran","Amon","Cpp","Phaser"};

            for(int i=0;i<mystr.length-1;i++){
                for(int j=i+1 ;j<mystr.length;j++){

                    if( mystr[i].compareTo(mystr[j]) > 0 ){
                       String tmp = mystr[i];
                       mystr[i]= mystr[j];
                       mystr[j]=tmp;
                    }
                }
            }

             // print array 
            for(int i=0;i<mystr.length;i++){
                System.out.println(mystr[i]);
            }

        char[] mychar = {'A','B','C','D','E','F','G','H','I'};

        for(int i=0;i<mychar.length;i++){
          System.out.println((int)mychar[i]); // print ascii value
        }

        }
}