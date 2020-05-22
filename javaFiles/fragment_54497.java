Map<String, Integer> breakPointsLocation = new HashMap<>();
    // some logic to fill this hashmap based on your search results (you can use grep)

    // header
    System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    System.out.println("<breakpoints>");
    for (Entry<String, Integer> entry: breakPointsLocation.entrySet())
    {
        System.out.println("<breakpoint enabled=\"true\" persistant=\"true\" registered=\"true\">");
        System.out.println("<resource path=\"" + entry.getKey() + "\" type=\"1\"/>");
        System.out.println("<marker charStart=\"1317\" lineNumber=\"" + entry.getValue() + "\" type=\"org.eclipse.jdt.debug.javaLineBreakpointMarker\">");
        System.out.println("<attrib name=\"charStart\" value=\"1317\"/>");
        // add some more attrbiutes here
        System.out.println("</marker>");
        System.out.println("</breakpoint>");
    } 

    //footer
    System.out.println("</breakpoints>");