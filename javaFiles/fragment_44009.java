Collections.sort(foo, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return new BigDecimal(o2.get("score")).compareTo(new BigDecimal(o1.get("score")));
            }
        });