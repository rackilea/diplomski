public void clearChecks(){
        for (List<ChildViewModel> value:expandableListDetail.values()) {
            for(ChildViewModel sample:value){
                sample.setCheckStatus(false);
            }
        }
        notifyDataSetChanged();