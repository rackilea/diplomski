public void addListenerLongPressBtn() {

        txtView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(view.getContext(), DragDropActivity.class);
                startActivity(intent);
                return true;
            }
        });
    }