public Collection<?> getDescendants(final Object itemId) {
        return getDescendantsRec(itemId, new ArrayList<Object>());
    }

    private Collection<?> getDescendantsRec(final Object itemId, final Collection<Object> siblings) {

            Collection<?> childrenIds = evoltWebUI.getPrimaryTreeView().getChildren(itemId);

            if (childrenIds.size() > 0){
                siblings.addAll(childrenIds);

                for (Object childItemId : childrenIds) {
                    getDescendantsRec(childItemId, siblings); 
                }
            } 

            return siblings;
        };