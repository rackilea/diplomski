addAncestorListener(new AncestorListener() {
        @Override
        public void ancestorAdded(AncestorEvent event) {
                height = getHeight();
                width = getWidth();
                //Modifications to the components here.
        }