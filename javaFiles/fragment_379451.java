public Collection<?> recursiveTreeSearch(Object objectItemID, Collection<?> siblings){

        if (evoltWebUI.getPrimaryTreeView().hasChildren(objectItemID)==true){
            // here you had an issue as well, as your line in fact did nothing visible to the caller
            siblings.addAll(evoltWebUI.getPrimaryTreeView().getChildren(objectItemID));

            for (int i = 0; i < evoltWebUI.getPrimaryTreeView().getChildren(objectItemID).size(); i++) {
                // here was your bug:
                recursiveTreeSearch(evoltWebUI.getPrimaryTreeView().getChildren(objectItemID).get(i), siblings); 
            }
        } 

        return siblings;
    };