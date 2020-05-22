for (Facet facet : getFacets()) {
        if(map.get(facet.getTranslatedValue()) == null) {
            map.put(facet.getTranslatedValue(), new ArrayList<com.schneider.gss.model.Facet>());
        }
        map.get(facet.getTranslatedValue()).add(facet);
    }