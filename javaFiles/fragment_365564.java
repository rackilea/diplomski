public void setCity(City city) {
        CustomCityView cityView = (CustomCityView) itemView;
        cityView.setCity(city);
        try {
            cityView.setCityButtonClickListener( (CityButtonClickListener) context);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }