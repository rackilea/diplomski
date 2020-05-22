listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Deal deal = all_deals.get(position);

                     Intent intent = new Intent(getActivity(), Deal1.class);
                     Bundle bundle = new Bundle();
                     bundle.putInt("CurrentSupporters", deal.getCurrentSupporters());
                     bundle.putInt("MaxSupporters", deal.getMaxSupporters());
                     bundle.putInt("RegularPrice", deal.getRegularPrice());
                     bundle.putInt("DiscountPrice", deal.getDiscountPrice());
                     intent.putExtras(bundle);
                     startActivity(intent);

        }
    });