public class StringFragementation

{

public static  String [][]  mymethod(String [] mystring)
{

    int row = 0, col = 0;

    String[][] india = new String[2][9];

    String mystringno2[];

    mystringno2 = mystring;

    int i = 0;

    int j = 0;

    String x = "_";

    int i1;

    String Nahda="";

    int l;

    for( l=0;l<mystringno2.length;l++)

    {

        Nahda =  Nahda.concat(mystringno2[l]);

    }

    System.out.println( Nahda );

    i1 =0;

    // set i before the loop
    i = Nahda.indexOf(x, i); 

    while (j <Nahda.length()) {

        i1 = Nahda.indexOf(x, i + 1);

        if (i1 == -1) { 
            // No more "_" we're at the end but we still need to add the last country!
            india[row][col] = Nahda.substring(i, Nahda.length() - 1);
            break;
        }

        india[row][col] = Nahda.substring(i + 1, i1);

        // set i to the "_" after the current country.
        i = i1; 

        System.out.print("Element  " + row + "  " + col + "   " + india[row][col].toString()+"\n");

        col++;

        if (col >= 9) { 
            // we're at the end of the first row, go to second row
            col = 0;
            row++;
        }

    }

    return india;

}

public static void main(String[] args)

{

    String[] s ={"_Netherlands_Iceland_Norway_Denmark_Usa_Brazil_Argentina_Colombuia_Bolivia","_Belgium_Romania_France_Germany_Switherland_Russia_Sweden_Italy_Austria"};

    String [][] singapore = new String[s.length][9];

    singapore = mymethod(s);

    for(int col=0; col < 9;col++)

        for(int row=0;row<s.length;row++) 

        {
            System.out.print(  singapore[row][col]+"\t"   )   ;

        }

    System.out.println("\n");

}

}