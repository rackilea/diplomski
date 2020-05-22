builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent menu = new Intent(context, MyOtherActivity.class);
                        context.startActivity(menu);
                        ((Activity) context).finish();
                    }
                });