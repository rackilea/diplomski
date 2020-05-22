donorSet.setName(donorData.getString("name"));
donorSet.setArea(donorData.getInt("area"));
donorList.add(donorSet);
//here put this line
bridge.donarList = donarList;
//rest code
Intent intent = new Intent(FindDonor.this, DonorSearchList.class);