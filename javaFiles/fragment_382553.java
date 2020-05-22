// Adding Click Listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.latest:
                                // Handle Latest Click
                                mSortingTextView.setText("Latest");
                                if (mTrips.size() > 0) {
                                    Collections.sort(mTrips, Trip.DATE_NEW_TO_OLD);
                                    Collections.sort(mTripListRecyclerViewAdapter.mTripsFiltered, Trip.DATE_NEW_TO_OLD);
                                }
                                mTripListRecyclerViewAdapter.notifyDataSetChanged();
                                return true;
                            case R.id.price_low_to_high:
                                // Handle Price (Low to High) Click
                                mSortingTextView.setText("Price (Low to High)");
                                if (mTrips.size() > 0) {
                                    Collections.sort(mTrips, Trip.PRICE_LOW_TO_HIGH);
                                    Collections.sort(mTripListRecyclerViewAdapter.mTripsFiltered, Trip.PRICE_LOW_TO_HIGH);
                                }
                                mTripListRecyclerViewAdapter.notifyDataSetChanged();
                                return true;
                            case R.id.price_high_to_low:
                                // Handle Price (High to Low) Click
                                mSortingTextView.setText("Price (High to Low)");
                                if (mTrips.size() > 0) {
                                    Collections.sort(mTrips, Trip.PRICE_HIGH_TO_LOW);
                                    Collections.sort(mTripListRecyclerViewAdapter.mTripsFiltered, Trip.PRICE_HIGH_TO_LOW);
                                }
                                mTripListRecyclerViewAdapter.notifyDataSetChanged();
                                return true;
                            case R.id.date_new_to_old:
                                // Handle Date (New to Old) Click
                                mSortingTextView.setText("Date (New to Old)");
                                if (mTrips.size() > 0) {
                                    Collections.sort(mTrips, Trip.DATE_NEW_TO_OLD);
                                    Collections.sort(mTripListRecyclerViewAdapter.mTripsFiltered, Trip.DATE_NEW_TO_OLD);
                                }
                                mTripListRecyclerViewAdapter.notifyDataSetChanged();
                                return true;
                            default:
                                return false;
                        }
                    }
                });