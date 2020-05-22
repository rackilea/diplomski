class CustomTableView<S> extends TableView<S> {
        private final EventHandler<MouseEvent> consumeEvent = MouseEvent::consume;

        @Override
        protected void layoutChildren() {
            super.layoutChildren();
            final Set<Node> dragRects = lookup("TableHeaderRow").lookupAll("Rectangle");
            for (Node dragRect : dragRects) {
                dragRect.removeEventFilter(MouseEvent.ANY, consumeEvent);
                dragRect.addEventFilter(MouseEvent.ANY, consumeEvent);
            }
        }
    }