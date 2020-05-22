for(int rowId:matchesMap.keySet()){
        if(!matchesMap.get(rowId).isEmpty()){
            Element cellElement = viewComponent.getView().getCell(rowId, columnId); 
            if(cellElement != null){
                cellElement.setInnerHTML(matchesMap.get(rowId));
            }
        }
    }