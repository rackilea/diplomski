public static void sortTitles(Movie2[] myMovies, Movie2[] dest)
    {
        for (int i = 0; i < myMovies.length; i++)
            {
                Movie2 next = myMovies[i];
                int insertIndex = 0;
                int k = i;
                while (k>0 && insertIndex == 0)
                    {
                        if (next.getTitle().compareTo(dest[k-1].getTitle()) > -1)
                            {
                                System.out.println("less than or equal");
                                insertIndex = k;
                            }
                        else 
                            {
                                System.out.println("greater than");
                                dest[k] = dest[k-1]; 
                            }
                        k--;
                    }
                dest[insertIndex] = next;
            } 
    }