@SuppressWarnings({ "unchecked", "rawtypes" })
public Map sortByValue(Map map) {
    List list = new LinkedList(map.entrySet());
    Collections.sort(list, new Comparator() {
        public int compare(Object o1, Object o2) {
        //Your custom sorting logic 
            if (((List<Integer>) (((Map.Entry) (o1)).getValue())).get(0) > ((List<Integer>) (((Map.Entry) (o2))
                        .getValue())).get(0)) {
                    return 1;
                } else if (((List<Integer>) (((Map.Entry) (o1)).getValue()))
                        .get(0) < ((List<Integer>) (((Map.Entry) (o2))
                        .getValue())).get(0)) {
                    return -1;
                } else {
                    if (((List<Integer>) (((Map.Entry) (o1)).getValue()))
                            .get(1) > ((List<Integer>) (((Map.Entry) (o2))
                            .getValue())).get(1)) {
                        return 1;
                    } else if (((List<Integer>) (((Map.Entry) (o1)).getValue()))
                            .get(1) < ((List<Integer>) (((Map.Entry) (o2))
                            .getValue())).get(1)) {
                        return -1;
                    } else {
                        if (((List<Integer>) (((Map.Entry) (o1)).getValue()))
                                .get(2) > ((List<Integer>) (((Map.Entry) (o2))
                                .getValue())).get(2)) {
                            return 1;
                        } else if (((List<Integer>) (((Map.Entry) (o1))
                                .getValue())).get(2) > ((List<Integer>) (((Map.Entry) (o2))
                                .getValue())).get(2)) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        });

        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }