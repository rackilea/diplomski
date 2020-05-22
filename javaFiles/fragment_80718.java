@FacesConverter("defaultNumberConverter")
public class DefaultNumberConverter extends NumberConverter {

    public DefaultNumberConverter() {
        setCurrencySymbol("");
        setGroupingUsed(true);
        setMaxFractionDigits(2);
        setType("currency");
    }

}