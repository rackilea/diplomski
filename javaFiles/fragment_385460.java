public void setMinimumFractionDigits(int newValue) {
    minimumFractionDigits = Math.max(0,newValue);
    if (maximumFractionDigits < minimumFractionDigits) {
        maximumFractionDigits = minimumFractionDigits;
    }
}