if (FavouriteStationHolder != null) {
            String jsonString = FavouriteStationHolder
                    .getString("stations", "");
            System.out.println("json String got in App class-->" + jsonString);

            Type type = new TypeToken<List<RadioStationBean>>() {
            }.getType();
            List<RadioStationBean> stations = gson.fromJson(jsonString, type);
            ArrayList<RadioStationBean> stationsList = new ArrayList<RadioStationBean>();
            for (int i = 0; i < stations.size(); i++) {
                RadioStationBean rBean = new RadioStationBean();
                rBean.setAdvertisements(stations.get(i).getAdvertisements());
                rBean.setCategories_id(stations.get(i).getCategories_id());
                rBean.setCategoy(stations.get(i).getCategoy());
                rBean.setDescription(stations.get(i).getDescription());
                rBean.setFacebook(stations.get(i).getFacebook());
                rBean.setId(stations.get(i).getId());
                rBean.setImage_url(stations.get(i).getImage_url());
                rBean.setIsDispTrack_Artist(stations.get(i)
                        .getIsDispTrack_Artist());
                rBean.setManager_detail(stations.get(i).getManager_detail());
                rBean.setPhone_show(stations.get(i).getPhone_show());
                rBean.setPhone_studio(stations.get(i).getPhone_studio());
                rBean.setPhone_toll_free(stations.get(i).getPhone_toll_free());
                rBean.setPlatform(stations.get(i).getPlatform());
                rBean.setStation_image(stations.get(i).getStation_image());
                rBean.setStation_manager(stations.get(i).getStation_manager());
                rBean.setStation_manager_id(stations.get(i)
                        .getStation_manager_id());
                rBean.setStation_name(stations.get(i).getStation_name());
                rBean.setStation_status(stations.get(i).getStation_status());
                rBean.setStream_format(stations.get(i).getStream_format());
                rBean.setStream_url(stations.get(i).getStream_url());
                rBean.setTheme_color(stations.get(i).getTheme_color());
                rBean.setTwitter(stations.get(i).getTwitter());
                rBean.setWeb_portal(stations.get(i).getWeb_portal());
                stationsList.add(rBean);
            }
            System.out.println("Custom ArrayList Retrieved in App Class"
                    + stationsList.get(0).getDescription());

            return stationsList;
}