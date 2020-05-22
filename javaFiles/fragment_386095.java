} else if (fruit.getFruit().equals(view.getResources().getString(R.string.tomato))) {
                        AlertDialog ad = new AlertDialog.Builder(getContext())
                                .create();
                        ad.setCancelable(false);
                        ad.setTitle("Seeded Fruit");
                        ad.setMessage("This fruit contains seeds.");
                        ad.setButton(context.getString(R.string.ok_text), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        ad.show();
                    } else {
                        intent = new Intent(getActivity(), FruitAppleActivity.class);
                    }

                    startActivity(intent);