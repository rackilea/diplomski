for (int i = 0; i < types.length; i++) {
        Multiset<String> textAndCount = TreeMultiset.create();
        if ("type::1".equals(types[i])) {
            for (String text : foobarness)
                textAndCount.add(text, 1);
        }
        if ("type::2".equals(types[i])) {
            for (String text : foobarness2)
                textAndCount.add(text, 1);
        }
        typeTextCount.put(types[i], textAndCount);
    }