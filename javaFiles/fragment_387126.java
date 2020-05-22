text.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo info) {
                menu.setHeaderTitle("Text context menu");
                menu.add(ContextMenu.NONE, MY_OPTION_CONTEXT_MENU, ContextMenu.NONE, "Some option");
            }
        });