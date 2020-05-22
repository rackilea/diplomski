List<Photoshoots> photoshootsList = new ArrayList<>();
                    for (int i = 0; i < parentArray.length(); i++) {
                        JSONObject mainObject = parentArray.getJSONObject(i);
                        JSONArray mainArray = mainObject.getJSONArray("FL");
                        Photoshoots photoshoot = new Photoshoots();


                    List<Photoshoots.potentialDetails> potentialDetails = new ArrayList<>();
                    List<Photoshoots.addressDetails> addressDetails = new ArrayList<>();
                    List<Photoshoots.dateDetails> dateDetails = new ArrayList<>();
                    List<Photoshoots.PotentialIDDetails> PotentialID = new ArrayList<>();
                        for (int s = 0; s < mainArray.length(); s++) {
                            if (s == 1) {
                                JSONObject subObject = mainArray.getJSONObject(s);
                                Photoshoots.potentialDetails PotentialName = new Photoshoots.potentialDetails();
                                String val = subObject.getString("val");
                                String content = subObject.getString("content");
                                PotentialName.setPotentialName(content);
                                potentialDetails.add(PotentialName);


                            } else if (s == 2) {
                                JSONObject subObject = mainArray.getJSONObject(s);
                                Photoshoots.addressDetails Address = new Photoshoots.addressDetails();
                                String val = subObject.getString("val");
                                String content = subObject.getString("content");
                                Address.setAddress(val + ": " + content);
                                addressDetails.add(Address);

                            } else if (s == 3) {
                                JSONObject subObject = mainArray.getJSONObject(s);
                                Photoshoots.dateDetails DateofShoot = new Photoshoots.dateDetails();
                                String val = subObject.getString("val");
                                String content = subObject.getString("content");
                                DateofShoot.setDateofShoot(val + ": " + content);
                                dateDetails.add(DateofShoot);


                            }else if (s==0){
                                JSONObject subObject = mainArray.getJSONObject(s);
                                Photoshoots.PotentialIDDetails PotentialIDAdd = new Photoshoots.PotentialIDDetails();
                                String val = subObject.getString("val");
                                String content = subObject.getString("content");
                                PotentialIDAdd.setPotentialIDDetails(val + ": " + content);
                                PotentialID.add(PotentialIDAdd);

                            }