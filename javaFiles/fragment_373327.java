for (int i = 0; i < ListA.size(); i++) {
        if (i == 0) {
            newList.add("<" + ListB.get(i) + "> " + ListA.get(i) + " ");
        }
        if (i >= 1) {
            String temp = ListB.get(i - 1);
            if (temp.equals(ListB.get(i))) {
                newList.add(ListA.get(i));
            } else {
                newList.add("</" + ListB.get(i - 1) + ">" + " <" + ListB.get(i) + "> " + ListA.get(i) + " ");
            }
        }
        if (i == ListA.size() - 1) {
            newList.add("</" + ListB.get(i) + ">");
        }
    }