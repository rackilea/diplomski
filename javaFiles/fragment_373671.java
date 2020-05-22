@Override
                    public void onClick(View v) {             
                        String nombrecampeon = String.valueOf(aatrox.getTag());
                        Intent i = new Intent();
                        i.putExtra("nombrecampeon",nombrecampeon);
                        getActivity().setResult(Activity.RESULT_OK,i);
                        getActivity().finish();
                    }
                });