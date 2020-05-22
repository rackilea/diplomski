@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
             View view = inflater.inflate(R.layout.fragment_test, container, false);

            view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_view);
                    dialog.findViewById(R.id.dialog_btn).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getActivity(), "Dialog btn clicked", Toast.LENGTH_LONG).show();
                        }
                    });

                    dialog.show();
                }
            });
            return view;
        }