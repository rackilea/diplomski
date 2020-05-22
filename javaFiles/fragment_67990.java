UriComponents comp = UriComponentsBuilder.fromHttpUrl(
    "http:/www.example.com/widgets/{widgetId}").queryParam("attr", "width", 
        "height").build();
UriComponents expanded = comp.expand(12);
assertEquals("http:/www.example.com/widgets/12?attr=width&attr=height", 
   expanded.toString());