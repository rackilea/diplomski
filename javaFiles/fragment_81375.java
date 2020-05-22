Collections.sort(listofcountries, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o1.replaceAll("[^a-zA-z]", "").compareTo(o2.replaceAll("[^a-zA-z]", ""));
            }
        });