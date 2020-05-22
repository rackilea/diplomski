while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            if (pairs.getValue() != null) {
                          System.out.println(pairs.getKey() + '='+ pairs.getValue());
            }
            it.remove(); // avoids a ConcurrentModificationException
        }