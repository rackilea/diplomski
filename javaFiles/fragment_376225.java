Scanner in = new Scanner(System.in) ;
    System.out.println("Enter grid size") ;

    int size = in.nextInt() ;  // size is the total number of incoming strings

    String str = in.next() ;
    int col = str.length()  ; // getting the length of the fisrt string to get column size for the grid

    char grid[][] = new char[size][col] ;
    grid[0] = str.toCharArray() ;  

    for (int i = 1 ; i < size ; i++)
    {
        str = in.next() ; 
        grid[i] = str.toCharArray() ; 
    }