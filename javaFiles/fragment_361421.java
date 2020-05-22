public static void main(String[] args)
{
    // create an array for artists
    artist[] artistList = new artist[0];

    // open the original file
    try {
        final File file = new File("p1artists.txt");
        final Scanner input = new Scanner(file);

        while (input.hasNextLine())
        {
            final int id = input.nextInt();
            final String name = input.next();
            // Skip to next line...
            input.netxLine();

            // Create a ne array, with one more element
            final artist[] newList = new artist[artistList.length + 1];
            // Copy the element references to the new array
            System.arraycopy(artistList, 0, newList, 0, artistList.length);
            // create a new artist and put it in the array
            newList[artistList.length] = new artist(id, name);
            // Replace old array with new one
            artistList = newList;
        }
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }

   for(artist e : artistList)
        System.out.println(e);
}