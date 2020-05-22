public static void main (String [] args)
{
     int i = 1;
     int j = 1;
     while  ((i < 10) && (j*j != 25)) //Semicolon removed from here
     { 
        i++;  
        ++j;
        System.out.println( i * j );
     }   
}