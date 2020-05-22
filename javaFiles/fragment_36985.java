private <S,T> void configureDropTargetColumn(TableColumn<S,T> column, ObjectProperty<TableColumn<?,?>> dropTarget) {

    Callback<TableColumn<S,T>, TableCell<S,T>> currentCellFactory = column.getCellFactory() ;

    column.setCellFactory(tc -> {
        TableCell<S,T> cell = currentCellFactory.call(tc);
        dropTarget.addListener((obs, oldColumn, newColumn) -> 
                cell.pseudoClassStateChanged(PseudoClass.getPseudoClass("drop-target"), newColumn==column));
        cell.setOnDragEntered(e -> dropTarget.set(column));
        cell.setOnDragExited(e -> dropTarget.set(null));
        return cell ;
    });
}