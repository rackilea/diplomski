public static void getDomainData() {

    try {
        JSONObject jsonobj = new JSONObject(Result);
        BusinessAllDataClass AllData = new BusinessAllDataClass();

        if (jsonobj.has(Constants.Key_CATEGORY)) {
            List<CategoryDataClass> Category_list = new ArrayList<CategoryDataClass>();
            JSONArray CatData = jsonobj
                    .getJSONArray(Constants.Key_CATEGORY);

            for (int i = 0; i < CatData.length(); i++) {
                if (CatData.getJSONObject(i).length() > 0) {
                    CategoryDataClass Cat = new CategoryDataClass();
                    JSONObject objCat = CatData.getJSONObject(i);
                    if (objCat.has(Constants.Key_CATEGORY_ID)) {
                        Cat.setCatId(objCat
                                .getString(Constants.Key_CATEGORY_ID));
                    }
                    if (objCat.has(Constants.Key_CATEGORY_NAME)) {
                        Cat.setCatName(objCat
                                .getString(Constants.Key_CATEGORY_NAME));
                    }
                    if (objCat.has(Constants.Key_CATEGORY_LOGO)) {
                        Cat.setCatLogo(objCat
                                .getString(Constants.Key_CATEGORY_LOGO));

                    }
                    if (objCat.has(Constants.Key_SUBCATEGORY)) {
                        List<SubCategoryDataClass> SubCategory_list = new ArrayList<SubCategoryDataClass>();
                        JSONArray SubCatData = objCat
                                .getJSONArray(Constants.Key_SUBCATEGORY);

                        for (int j = 0; j < 3; j++) {
                            if (SubCatData.getJSONObject(j).length() > 0) {
                                SubCategoryDataClass SubCat = new SubCategoryDataClass();
                                JSONObject objSubCat = SubCatData
                                        .getJSONObject(j);
                                if (objSubCat
                                        .has(Constants.Key_SUBCATEGORY_ID)) {
                                    SubCat.setSubCatId(objSubCat
                                            .getString(Constants.Key_SUBCATEGORY_ID));

                                }
                                if (objSubCat
                                        .has(Constants.Key_SUBCATEGORY_NAME)) {
                                    SubCat.setSubCatName(objSubCat
                                            .getString(Constants.Key_SUBCATEGORY_NAME));

                                }
                                if (objSubCat
                                        .has(Constants.Key_SUBCATEGORY_LOGO)) {
                                    SubCat.setSubCatLogo(objSubCat
                                            .getString(Constants.Key_SUBCATEGORY_LOGO));

                                }
                                if (objSubCat
                                        .has(Constants.Key_SUBCATEGORY_LONGITUDE)) {
                                    SubCat.setLongitude(objSubCat
                                            .getString(Constants.Key_SUBCATEGORY_LONGITUDE));

                                }
                                if (objSubCat
                                        .has(Constants.Key_SUBCATEGORY_LATITUDE)) {
                                    SubCat.setLatitiude(objSubCat
                                            .getString(Constants.Key_SUBCATEGORY_LATITUDE));

                                }
                                if (objSubCat.has(Constants.Key_DETAIL)) {
                                    List<SubCategorDescriptionDataClass> SubCatDescription_list = new ArrayList<SubCategorDescriptionDataClass>();
                                    JSONObject DescObj = objSubCat
                                            .getJSONObject(Constants.Key_DETAIL);
                                    SubCategorDescriptionDataClass SubCatDesc = new SubCategorDescriptionDataClass();
                                    if (DescObj.has(Constants.Key_STREET)) {
                                        SubCatDesc
                                                .setStreet(DescObj
                                                        .getString(Constants.Key_STREET));

                                    }
                                    if (DescObj.has(Constants.Key_CITY)) {
                                        SubCatDesc
                                                .setCity(DescObj
                                                        .getString(Constants.Key_CITY));

                                    }
                                    if (DescObj.has(Constants.Key_STATE)) {
                                        SubCatDesc
                                                .setState(DescObj
                                                        .getString(Constants.Key_STATE));

                                    }
                                    if (DescObj.has(Constants.Key_ZIPCODE)) {
                                        SubCatDesc
                                                .setzipcode(DescObj
                                                        .getString(Constants.Key_ZIPCODE));

                                    }
                                    if (DescObj
                                            .has(Constants.Key_DESCRIPTION)) {
                                        SubCatDesc
                                                .setDesc(DescObj
                                                        .getString(Constants.Key_DESCRIPTION));

                                    }

                                    if (DescObj.has(Constants.Key_SERVICES)) {
                                        SubCatDesc
                                                .setServices(DescObj
                                                        .getString(Constants.Key_SERVICES));
                                    }
                                    if (DescObj
                                            .has(Constants.Key_WORKINGHOUR)) {
                                        SubCatDesc
                                                .setWorkingHour(DescObj
                                                        .getString(Constants.Key_WORKINGHOUR));
                                    }
                                    if (DescObj
                                            .has(Constants.Key_CONTACT_NO)) {
                                        SubCatDesc
                                                .setContactNo(DescObj
                                                        .getString(Constants.Key_CONTACT_NO));
                                    }
                                    if (DescObj
                                            .has(Constants.Key_USER_EMAIL)) {
                                        SubCatDesc
                                                .setUsreEmail(DescObj
                                                        .getString(Constants.Key_USER_EMAIL));
                                    }
                                    if (DescObj.has(Constants.Key_WEBSITE)) {
                                        SubCatDesc
                                                .setWebsite(DescObj
                                                        .getString(Constants.Key_WEBSITE));
                                    }
                                    if (DescObj.has(Constants.Key_IMAGE)) {
                                        JSONArray DescImage = DescObj
                                                .getJSONArray(Constants.Key_IMAGE);

                                        for (int k = 0; k < DescImage
                                                .length(); k++) {

                                            SubCatDesc.ImageData
                                                    .add(DescImage
                                                            .getString(k));

                                        }
                                        SubCatDescription_list
                                                .add(SubCatDesc);

                                        SubCat.setSubCatDescList(SubCatDescription_list);
                                    }
                                }
                                SubCategory_list.add(SubCat);

                                Cat.setSubCatList(SubCategory_list);
                            }
                        }

                    }
                    Category_list.add(Cat);
                }
            }

            AllData.setCatList(Category_list);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }