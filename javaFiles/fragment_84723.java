Map<String, Object> addressContent = new HashMap<>();
addressContent.put("region", srtRegion);
addressContent.put("region_id", srtRegionID);
addressContent.put("country_id", srtCountryID);

// Here wrap strStreet in a List
addressContent.put("street", Arrays.asList(srtStreet));

addressContent.put("postcode", srtPostcode);
addressContent.put("city", srtCity);
addressContent.put("telephone", srtTelephone);
addressContent.put("company", srtCompany);
addressContent.put("firstname", srtFirstname);
addressContent.put("lastname", srtLastname);
addressContent.put("document", srtDocument);