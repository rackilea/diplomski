public void get_minimum_of_the_column_of_local_maximum ()
{
    for ( int i = 0; i < A.length; i++ )
    {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        int index_of_maximum_in_its_row = 0;

        for ( int j = 0; j < A [ i ].length; j++ )
            if ( A [ i ] [ j ] > max )
                {
                    max = A [ i ] [ j ];
                    index_of_maximum_in_its_row = j;
                }

        for ( int j = 0; j < A [ index_of_maximum_in_its_row ].length; j++ )
            if ( A [ j ] [ index_of_maximum_in_its_row ] < min )
                min = A [ j ] [ index_of_maximum_in_its_row ];

        System.out.print( " Maximum of row [" + i + "] = " + max);
        System.out.println( " Minimum of column [" + index_of_maximum_in_its_row + "] = " + min );
    }
}