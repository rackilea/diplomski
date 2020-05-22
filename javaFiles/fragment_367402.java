package de.zalando.shop.frontend.springmvc.controller.user.account;

/**
 * @author  mochieng (marembo.isaiah.ochieng@zalando.de)
 * @since   Nov 13, 2015
 */
public class MeasureDefinition {

    private String name;

    private String value;

    private String moreValuesAndProperties;

    public MeasureDefinition(final String name) {
        this.name = name;
    }

    public MeasureDefinition(final String name, final String value, final String moreValuesAndProperties) {
        this.name = name;
        this.value = value;
        this.moreValuesAndProperties = moreValuesAndProperties;
    }

    public MeasureDefinition() { }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getMoreValuesAndProperties() {
        return moreValuesAndProperties;
    }

}