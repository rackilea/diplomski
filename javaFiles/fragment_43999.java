public void findSameStartingLetter( BigNode front, String letter )
    {
        BigNode curr = front;
        while( curr != null )
        {
            String name = curr.dataitems;
            if( name.startsWith( letter ) )
            {
                System.out.println( name );
            }
            curr = curr.next;
        }
    }