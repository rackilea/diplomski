public static List<String> algo(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<>();

        int lastIndexFound = 0;

        for(int i = 0; i < l1.size(); i++) {
            for(int j = lastIndexFound; j < l2.size(); j++) {
                String list1element = l1.get(i);
                String list2element = l2.get(j);
                if(list1element.equals(list2element)) {
                    result.add(list1element);
                    lastIndexFound = j + 1;
                    break;
                }
            }
        }

        return result;
    }