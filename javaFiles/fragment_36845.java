View view;
    if (defaultType){
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
    }else {
        view = LayoutInflater.from(context).inflate(noteCheck ? R.layout.item_note_check : R.layout.item_note_photo, parent, false);
    }