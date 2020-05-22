radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousSelected = getAdapterPosition();
                notifyItemRangeChanged(0, modelGetAddressList.size());

                // I want this All String will be send when i click button in Fragment
                String getNameUser = nameUser.getText().toString();
                String getAddressUser = streetName.getText().toString();
                String getCountryUser = countryUser.getText().toString();
                String getBlokUser = blokAddressUser.getText().toString();
                String getCityUser = cityAddressUser.getText().toString();
                String getPhoneUser = phoneUser.getText().toString();

                callback.onItemClicked(getNameUser //, the rest..);

            }
        });