public class WeatherAdapter extends ArrayAdapter<Weather>{

    // ...

    private String buttonPressed = "Köp Kurs";

    public void setButtonPressed(String s) {
        buttonPressed = s;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // ... 

        Weather weather = data[position];
        holder.txtTitle.setText(weather.getName());

        if(buttonPressed == "Köp Kurs"){
            holder.imgIcon.setText(Double.toString(weather.getBuyingRate()));
        }
        else if(buttonPressed == "Antal"){
            holder.imgIcon.setText(Double.toString(weather.getNrOfSharesInPortfolio()));
        }

        return row;
    }

    // ...
}