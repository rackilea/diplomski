List<Integer> numbers = stream
            .parallel()
            .reduce(
                    new ArrayList<>(),
                    (list, data) -> {
                        ArrayList<Integer> newList = new ArrayList<>(list);
                        newList.add(data);
                        return newList;
                    },

                    (left, right) -> {
                        ArrayList<Integer> newList = new ArrayList<>(left);
                        newList.addAll(right);
                        return newList;
                    });