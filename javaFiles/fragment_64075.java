Map<String, Map<Boolean, Map<String, String>>> data = postmans.stream()
            .collect(Collectors.groupingBy(
                    d -> d.get("date"),
                    TreeMap::new,
                    Collectors.partitioningBy(
                            d -> d.get("type").equals("true"),
                            Collectors.reducing(
                                    new HashMap<>(),
                                    (left, right) -> {

                                        Map<String, String> map = new HashMap<>();

                                        String leftCode = left.get("code");
                                        String leftNumber = left.get("number");

                                        if (leftCode == null) {
                                            map.putAll(left);
                                        } else {
                                            map.put(leftCode, leftNumber);
                                        }

                                        String rightCode = right.get("code");
                                        String rightNumber = right.get("number");

                                        map.put(rightCode, rightNumber);

                                        return map;

                                    }))));