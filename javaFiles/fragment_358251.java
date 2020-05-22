class CustomTableView<S> extends TableView<S>{
        private Node headerRow;

        @Override
        protected void layoutChildren() {
            super.layoutChildren();
            if(headerRow ==null){
                headerRow = (Region) lookup("TableHeaderRow");
                headerRow.addEventFilter(MouseEvent.MOUSE_DRAGGED, MouseEvent::consume);
            }
        }
    }