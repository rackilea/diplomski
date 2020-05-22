numbers =
    (ArrayList<Integer>)
            numbers.stream()
                    .sorted((n1, n2) -> {
                        if (((n1 >= 21) && (n2 >= 21)) || ((n1 <= 20) && (n2 <= 20))) {
                            return  n1 - n2;
                        } else {
                            return n2 - n1;
                        }
                    }).collect(Collectors.toList());