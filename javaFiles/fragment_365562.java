public class CustomCityView extends RelativeLayout 
    implements View.OnClickListener {

    public interface CityButtonClickListener {
        void onCityButtonClick(City city);
    }

    private CityButtonClickListener buttonClickListener;

    public void setCityButtonClickListener(CityButtonClickListener listener) {
        this.buttonClickListener = listener;
    }

    ...