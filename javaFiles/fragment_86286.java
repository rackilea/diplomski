private static void processRowHandle(SlotHandle pSlotHandle, ReportGroup pGroupInfo) throws SemanticException {
    if (pSlotHandle == null) return;
    for(Object obj : pSlotHandle.getContents()){
        if (obj instanceof RowHandle){
            SlotHandle cells = ((RowHandle)obj).getCells();
            if (cells == null) continue;
            for(Object item : cells.getContents()){
                if (item instanceof CellHandle){
                    SlotHandle content = ((CellHandle)item).getContent();
                    if (content == null) continue;
                    for(Object cell : content.getContents()){
                        if (cell instanceof DesignElementHandle) processGroupLabels((DesignElementHandle) cell, pGroupInfo);
                    }
                }
            }
        }
    }
}

private static void processGroupLabels(DesignElementHandle pElementHandle, ReportGroup pGroupInfo) throws SemanticException {
    if (pElementHandle instanceof DataItemHandle){
        DataItemHandle dataItemHandle = (DataItemHandle)pElementHandle;
        if (pGroupInfo.getOldBindingName().equals(dataItemHandle.getResultSetColumn())){
            dataItemHandle.setResultSetColumn(pGroupInfo.getNewColumn().getBindingNameText());
        }
    }
    if (pElementHandle instanceof TextItemHandle){
        String newColumnBindingText = ExpressionUtil.createRowExpression(pGroupInfo.getNewColumn().getBindingNameText());
        String content = ((TextItemHandle)pElementHandle).getContent().replace(pGroupInfo.getOriginalExpression(), newColumnBindingText);
        ((TextItemHandle)pElementHandle).setContent(content);
    }
}