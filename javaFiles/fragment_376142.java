List<Entry<String, Object>> list = new ArrayList<Entry<String, Object>>();
    list.addAll(set);
    Collections.sort(list, new Comparator<Entry<String, Object>>() {
        @Override
        public int compare(Entry<String, Object> o1, Entry<String, Object> o2) {
            // TODO Implement you sorting
            return 0;
        }
    });
    JRBeanCollectionDataSource bdsSorted = new JRBeanCollectionDataSource(list);