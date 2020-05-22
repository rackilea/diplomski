Elements aElements = doc.select("a");
    Elements bElements = doc.select("b");


    // This 'if-else' block is optional
    if( aElements.size() != bElements.size() )
    {
        // Error handling - if required
    }
    else
    {
        // Iterate over all elements
        for( int i = 0; i < aElements.size(); i++ )
        {
            Post p = new Post();    // Create a Post

            p.setA(aElements.get(i).text());    // Set A Value
            p.setB(bElements.get(i).text());    // Set B Value

            PostList.add(p);    // Add the Post to List
        }
    }