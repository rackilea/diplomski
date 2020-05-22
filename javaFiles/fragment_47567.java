@Override
protected void onPostExecute(String[] result) {
    if (result != null) {
        mForecastAdapter.clear();
        for(String dayForecastStr : result) {
            mForecastAdapter.add(dayForecastStr);
        }
        // Update adapter
        mForecastAdapter.notifyDataSetChanged();
    }
}