private void updateDisplay() {
    if (mTemperatureValue != null)
        mTemperatureValue.setText(mCurrent.getTemperature()+"");
    if (mHumidityValue != null) 
        mHumidityValue.setText(mCurrent.getHumidity()+"%");
    if (mPrecipChanceValue != null)
        mPrecipChanceValue.setText(mCurrent.getPrecipProbability()+"%");
    if (mSummaryText != null)
        mSummaryText.setText(mCurrent.getSummary());
    if (mTimeValue != null)
        mTimeValue.setText(mCurrent.getFormattedTime());
    mIconImage.setImageDrawable(getResources().getDrawable(mCurrent.getIconID()));
}