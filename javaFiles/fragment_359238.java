listProducto = new ListProducto();
    listProducto.addSearchEventListener(new searchEventListener() {
        public void resultFound(EventObject e) {
            listProductoSearchPerformed();
        }
    });