Iterator<String> supplieIter  = suppliedContent.keySet().iterator();

    while(supplieIter.hasNext()){
        key = supplieIter.next();

        if (EqualityUtils.isMatching(rgx, key)) {
           supplieIter.remove()
        }
    }