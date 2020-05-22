getActivity().runOnUiThread(new Runnable() {
    @Override
    public void run() {
        curWeather.setText(Integer.toString(currentTempCelc));
    }
});