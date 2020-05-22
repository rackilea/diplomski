public static void main(String [] args)
    {
        String number;
        number = JOptionPane.showInputDialog("Enter Number"); 
        int b = number.length() ;
        char [] a = new char [number.length() ] ;
        for ( int i = 0 ; i < number.length()  ;i++)
            a[i] = number.charAt(i) ;
        for (int i = 0 ; i < a.length  ; i++)
            {
                number += ( a[i] );
                number += ' ' ;
            }
        number = number.substring(b) ;
        JOptionPane.showMessageDialog(null,"Th… new result is" + ' ' +  number,"Results",
                JOptionPane.PLAIN_MESSAGE) ;
        System.exit(0);
    }