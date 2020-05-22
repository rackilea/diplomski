int viewType;
    if ( groups.get ( position ).getImagePath () != null ) {
        viewType = TYPE_IMAGE;
    } else {
        viewType = TYPE_GROUP;
    }
    return viewType;