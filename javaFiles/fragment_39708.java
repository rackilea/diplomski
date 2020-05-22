ArrayList<QuoteProductDTO> lstQuoteProductDTO = new ArrayList<>();
        ArrayList<QuoteProductDTO> nextQuoteProductDTO = new ArrayList<>();

        // empty Quote for Optional handling below.
        QuoteProductDTO emptyQuote = new QuoteProductDTO("EMPTY", -1, -1);

        lstQuoteProductDTO.add(
                new QuoteProductDTO("Product", 10, 15.5));
        lstQuoteProductDTO.add(
                new QuoteProductDTO("Product", 05, 2.5));
        lstQuoteProductDTO.add(
                new QuoteProductDTO("Product", 13, 1.0));
        lstQuoteProductDTO.add(
                new QuoteProductDTO("Product", 02, 2.0));