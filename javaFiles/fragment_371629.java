package org.stackoverflow.helizone.test;

public class Configuration {

    @JsonArrayMember("{width: 1024}")
    private Boolean width;

    @JsonArrayMember("{height: 768}")
    private Boolean height;

    @JsonArrayMember("'valid'")
    private Boolean isValid;

    public Boolean getWidth() {
        return width;
    }

    public void setWidth(Boolean width) {
        this.width = width;
    }

    public Boolean getHeight() {
        return height;
    }

    public void setHeight(Boolean height) {
        this.height = height;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}