private Set filter(MetadatRetrievalDTO[] data, Map<String, String> filter) {
        Set<Integer> rtnIdSet = new HashSet();
        for (MetadatRetrievalDTO dto : data) {
            rtnIdSet.add(dto.getArticleId());
        }

        Set<Integer> filterSet = new HashSet();
        for (String key : filter.keySet()) {
            filterSet.clear();
            String value = filter.get(key);
            for (MetadatRetrievalDTO dto : data) {
                if (key.equals(dto.getMetadataName()) && value.equals(dto.getMetadataValue())) {
                    filterSet.add(dto.getArticleId());
                }
            }

            rtnIdSet.retainAll(filterSet);
        }

        return  rtnIdSet;
    }