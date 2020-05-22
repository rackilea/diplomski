FixParser parser = new FixParser();

    // define a repeating group for a message type:
    parser.addGroupTemplate(QuoteStatusRequest, NoRelatedSym, 
                            Symbol, FutSettDate, SecurityDesc);

    FixMessage fixMsg = parser.parse(byteBufferWithFixMessage);

    fixGroup = fixMsg.getGroup(NoRelatedSym);

    System.out.println(fixGroup.getNumberOfElements()); // => 4

    // you can also print the whole fix group for debugging purposes:
    System.out.println(fixGroup);
    // Symbol(55)=AAPL FutSettDate(64)=1 SecurityDesc(107)=blah1 | Symbol(55)=IBM FutSettDate(64)=2 SecurityDesc(107)=blah2 | Symbol(55)=LDK FutSettDate(64)=3 SecurityDesc(107)=blah3 | Symbol(55)=FB FutSettDate(64)=4 SecurityDesc(107)=blah4

    System.out.println();

    Iterator<FixGroupElement> iter = fixGroup.iterator();

    while(iter.hasNext()) {

        FixGroupElement elem = iter.next();

        // fetch fix tag values as usual:
        System.out.println(elem.getString(Symbol));
        System.out.println(elem.getInt("FutSettDate"));
        System.out.println(elem.getString(107));

        // you can also print the whole element for debugging purposes:
        System.out.println(elem);
        System.out.println();
    }
}