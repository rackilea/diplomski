System.out.printf("%s%n","Please enter a number to search for: "); 
    int numberSearch = stdIn.nextInt(); 
    boolean found = false;
    for(int i=0; i<numbers.length; i++)
    {
        if (numbers[i]==numberSearch)
        {
            System.out.printf("Search Value: %d found at location: %d 
                                     in the unsorted array",numberSearch,i); 
            found = true;
        }

        if (sortedNumbers[i]==numberSearch)
        {
            System.out.printf("Search Value: %d found at location: %d
                                      in the sorted array",numberSearch,i);
        }
    }

    if (!found) 
    {
        System.out.printf("Search Value: %d was not found", numberSearch); 
    }