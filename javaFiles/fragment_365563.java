public class CustomCityView extends RelativeLayout 
    implements View.OnClickListener {

    ...

    @Override 
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (buttonClickListener != null) {
                    buttonClickListener.onCityButtonClick(city);
                }
                break;
            default:
                break;
        }
    }

    public void setCity(final City city) {
        this.city = city;

        cityName.setText(city.getName());

        button.setOnClickListener(this);
    }