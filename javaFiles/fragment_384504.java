@Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // TODO Auto-generated method stub

                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.first_fragment, secondFragment);
                fragmentTransaction.commit();
            }