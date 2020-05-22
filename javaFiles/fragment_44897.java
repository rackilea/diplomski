final CharSequence[] items = {"Camera", "Memory Card"};

builder.setTitle(R.string.pic_option);
                    builder.setIcon(R.drawable.camera_icon);
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {
                          launchCamera(item);
                        }
                    });
                    builder.create();
                    builder.show();