final List<Integer> integers =
        ListUtils.transformedList(strings, new Transformer<String, Integer>() {
            @Override
            public Integer transform(String s) {
                return Integer.parseInt(s);
            }
        });