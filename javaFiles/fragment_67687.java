String temp;
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            temp = (String) it.next();
            System.out.print(temp + ", ");
            for (Entry<String, HashMap<String, List<Integer>>> entry : COOLMAP.entrySet()) {
                boolean hasValue = false;
                for (Entry<String, List<Integer>> innerEntry : entry.getValue().entrySet()) {
                    String innerKey = innerEntry.getKey();
                    if (innerKey.equals(temp)) {
                        System.out.print(innerEntry.getValue() + ", ");
                        hasValue = true;
                    }
                }
                if (!hasValue) {
                    System.out.print(", ,");
                }
            }
            System.out.println();
        }