View button2= getActivity().findViewById(R.id.saveContact);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), AddContactActivity.class);
                    startActivity(intent);
                }
            });