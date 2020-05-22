searchField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.KEYCODE_ENTER)
                    // do stuff here
                return false;
            }

        });