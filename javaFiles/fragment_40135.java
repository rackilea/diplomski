for (int i = 0; i < artistList.getLength(); ++i) {
        Element e = (Element) artistList.item(i);
        artist= e.getFirstChild().getNodeValue();

        book = new Book(); // A new object here
        book.setIsbn(artist);
        book.setName(song);
        ... // Process book
    }