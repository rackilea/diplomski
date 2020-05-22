Document doc = ... // Load / parse your document here

    Element listRoot = doc.select("ol").first(); // Select the root-element (!) of the list here. 
    final String output = createList(listRoot, 0); // Convert the list

    System.out.println(output); // Ouput