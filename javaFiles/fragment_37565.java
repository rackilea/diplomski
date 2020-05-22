//the new ArrayList is needed so remove is supported
    List<String> fromTagList = new ArrayList(Arrays.asList(new String[] {"a", "b", "c", "1", "2", "3"}));
    List<String> fromImageList = new ArrayList(Arrays.asList(new String[] {"b", "b", "c", "d", "2", "3", "4"}));

    outer: for (int i = fromTagList.size()- 1; i >= 0; i--) {
        for (int k = fromImageList.size() - 1; k >= 0; k--) {
        System.out.println("i: " + i + " k: " + k);
        if (fromTagList.get(i).equals(fromImageList.get(k))) {
            fromTagList.remove(i);
            fromImageList.remove(k);
            continue outer;
        }
        }
    }

    System.out.println("fromTag  : " + fromTagList);
    System.out.println("fromImage: " + fromImageList);