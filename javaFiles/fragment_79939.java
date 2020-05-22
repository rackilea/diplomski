public boolean isSatisfied() {
    if( type.equals("and")) {
        for( Component component : components ) {
            if( !component.isSatisfied() ) {
                return false;
            }
        }
        return true;
    }
}