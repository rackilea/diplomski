try {
                    AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                            .setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
                            .build();

                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                            .setFilter(typeFilter)
                            .setBoundsBias(new LatLngBounds(new LatLng(28.7041, 77.1025), new LatLng(28.7041, 77.1025)))
                            .build(TestatorDetailsActivity.this);
                    startActivityForResult(intent, DEFAULT_KEYS_SEARCH_GLOBAL);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                    // TODO: Handle the error.
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                    // TODO: Handle the error.
                }