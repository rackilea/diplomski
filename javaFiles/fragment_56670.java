public class TournamentsConverter implements Converter<Tournaments>
{
    private final Serializer serializer = new Persister();


    @Override
    public Tournaments read(InputNode node) throws Exception
    {
        Tournaments tournaments = new Tournaments();
        InputNode childNode = node.getNext();

        // Iterate over all childs of 'Tournaments'
        while( childNode != null )
        {
            if( childNode.getName().equals("Category") == true )
            {
                final String categoryId = childNode.getAttribute("category_id").getValue();

                List<Tournament> tournamentList = new ArrayList<>();
                InputNode child = childNode.getNext();

                // Iterate over all childs of 'Category'
                while( child != null )
                {
                    // Use a Serializer to read the nodes data
                    Tournament tournament = serializer.read(Tournament.class, child);
                    tournamentList.add(tournament);

                    child = childNode.getNext();
                }

                // Insert the Id / Tournament's pair
                tournaments.put(categoryId, tournamentList);
            }

            childNode = node.getNext();
        }

        return tournaments;
    }


    @Override
    public void write(OutputNode node, Tournaments value) throws Exception
    {
        // Implement as needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

}