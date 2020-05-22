case R.id.btn_submit_search_client:

            ClientsSearchArray.ClientsSearchArray.clear();
            Client currentClient = null;

            if (searchName.getText().toString().trim().equals("")
                    && searchVisitAddress.getText().toString().trim().equals("")
                    && searchVisitCity.getText().toString().trim().equals("")
                    && searchVisitZipcode.getText().toString().trim().equals("")
                    && searchVisitCountry.getText().toString().trim().equals("")
                    && searchPostalAddress.getText().toString().trim().equals("")
                    && searchPostalCity.getText().toString().trim().equals("")
                    && searchPostalZipcode.getText().toString().trim().equals("")
                    && searchPostalCountry.getText().toString().trim().equals("")
                    && searchContactSurname.getText().toString().trim().equals("")
                    && searchContactFirstname.getText().toString().trim().equals("")
                    ) {
                Toast.makeText(this.getActivity(), "Please give search paramaters", Toast.LENGTH_LONG).show();
            } else {
                for (Client client : ClientsArray.ClientsArray) {
                    if (client.getName().trim().contains(searchName.getText().toString().trim())
                            && client.getVisitAddress().trim().contains(searchVisitAddress.getText().toString().trim())
                            && client.getVisitCity().trim().contains(searchVisitCity.getText().toString().trim())
                            && client.getVisitZipcode().trim().contains(searchVisitZipcode.getText().toString().trim())
                            && client.getVisitCountry().trim().contains(searchVisitCountry.getText().toString().trim())
                            && client.getPostalAddress().trim().contains(searchPostalAddress.getText().toString().trim())
                            && client.getPostalCity().trim().contains(searchPostalCity.getText().toString().trim())
                            && client.getPostalZipcode().trim().contains(searchPostalZipcode.getText().toString().trim())
                            && client.getPostalCountry().trim().contains(searchPostalCountry.getText().toString().trim())) {

                        if (!searchContactSurname.getText().toString().trim().equals("")
                                || !searchContactFirstname.getText().toString().trim().equals("")) {
                            for (Contact contact : client.getContactList()) {
                                if (contact.getFirstname().trim().contains(searchContactFirstname.getText().toString().trim())
                                        && contact.getSurname().trim().contains(searchContactSurname.getText().toString().trim())) {

                                    if(client.getContactList().size() != 0){
                                        currentClient = client;
                                        if (!ClientsSearchArray.ClientsSearchArray.contains(currentClient)) {
                                            ClientsSearchArray.ClientsSearchArray.add(currentClient);
                                        }
                                    }
                                }
                            }
                        }else{
                            currentClient = client;
                            if (!ClientsSearchArray.ClientsSearchArray.contains(currentClient)) {
                                ClientsSearchArray.ClientsSearchArray.add(currentClient);
                            }
                        }
                    }
                }

                if (ClientsSearchArray.ClientsSearchArray.size() > 1) {
                    SearchedClientsListFragment searchedClientsListFragment = new SearchedClientsListFragment();
                    transaction.replace(R.id.group, searchedClientsListFragment, "searchedcfrag");
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else if (currentClient != null) {
                    ViewClientFragment viewClientFragment = new ViewClientFragment();
                    viewClientFragment.setCurrentClient(currentClient);
                    transaction.replace(R.id.group, viewClientFragment, "viewcfrag");
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {
                    Toast.makeText(this.getActivity(), "Client Not Found", Toast.LENGTH_LONG).show();
                }


            }
            break;
    }

}