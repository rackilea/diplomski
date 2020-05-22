public static ScrollBar getVerticalScrollbar(TableView<?> table) {
    ScrollBar result = null;
    for(Node n : table.lookupAll(".scroll-bar")) {
        if(n instanceof ScrollBar) {
            ScrollBar bar = (ScrollBar) n;
            if(bar.getOrientation().equals(Orientation.VERTICAL)) {
                result = bar;
            }
        }
    }
    return result;
}