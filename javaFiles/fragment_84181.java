Query query = em.createNamedQuery("AuthorWork.findAll");
        List authorList = query.getResultList();
        Iterator authorIterator = authorList.iterator();
        while (authorIterator.hasNext()) {
            author = (AuthorWorkEmbedded) authorIterator.next();
            System.out.println("Book Id " + author.setEmbeddedId().getBookId() + " " + "Author" + author.getEmbeddedId().getAuthorId() + "");
            System.out.println(""+author.getColumnA());
        }