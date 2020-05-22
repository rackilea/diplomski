@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // get the adapter, then get the name from the adapter at that position
            WorldListAdapter adapter = (WorldListAdapter) parent.getAdapter();
            String country = adapter.getItem(position);

            if (mTwoPane) {
                setItemNormal();
                View rowView = view;
                setItemSelected(rowView);

                Fragment newFragment;
                if (country.equals(view.getResources().getString(R.string.africa))) {
                    newFragment = new FragmentAfrica();
                } else if (country.equals(view.getResources().getString(R.string.asia))) {
                    newFragment = new FragmentAsia();
                } else if (country.equals(view.getResources().getString(R.string.europe))) {
                    newFragment = new FragmentEurope();
                } else {
                    newFragment = new FragmentAfrica();
                }
                WorldActivity activity = (WorldActivity) view.getContext();
                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.detail_container, newFragment);
                transaction.commit();
            } else {
                Intent intent;
                if (country.equals(view.getResources().getString(R.string.africa))) {
                    intent = new Intent(getActivity(), AfricaActivity.class);
                } else if (country.equals(view.getResources().getString(R.string.asia))) {
                    intent = new Intent(getActivity(), AsiaActivity.class);
                } else if (country.equals(view.getResources().getString(R.string.europe))) {
                    intent = new Intent(getActivity(), EuropeActivity.class);
                } else {
                    intent = new Intent(getActivity(), AfricaActivity.class);
                }
                startActivity(intent);
            }
        }