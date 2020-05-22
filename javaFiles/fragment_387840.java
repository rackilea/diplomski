public HashMap<String, List<ListDisplay>> getData() {
        HashMap<String, List<ListDisplay>> data = new HashMap<>();
        List<ListDisplay> list = initData();

        for (ListDisplay d : list) {
            // if null add
            if (data.get(d.getConstituency()) == null) {
                List<ListDisplay> internal = new ArrayList<>();
                internal.add(d);
                data.put(d.getConstituency(), internal);
            }
            // else modify
            else {
                List<ListDisplay> hashlist = data.get(d.getConstituency());
                hashlist.add(d);
                data.remove(d.getConstituency());
                data.put(d.getConstituency(), hashlist);
            }
        }

        return data;
    }