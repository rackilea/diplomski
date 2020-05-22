Arrays.sort(myData , new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return ((String) o2[1]).compareTo(o1[1]);
            }
        });