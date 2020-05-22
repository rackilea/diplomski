private afRatio = 14.7;

public void setAfRatio(float ratio) {
    if(ratio <= 0)
        throw new IllegalArgumentException("A/F ratio must be greater than zero");
    afRatio = ratio;
}