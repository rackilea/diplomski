String html = "<p>An <br/><b></b> <a href='http://example.com/' target=\"h\"> <b> example <a><p></b>this is  the </a> link </p>";
       Traverser traverser = new Traverser();

       Document document = Jsoup.parse(html, "", Parser.xmlParser());// you can use the html parser as well. which will add the html tags

       document.traverse(traverser);
       System.out.println(traverser.extractHtmlBuilder.toString());