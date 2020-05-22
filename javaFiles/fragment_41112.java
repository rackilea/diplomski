import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Root {

    private Object settingValue;

    public Object getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(final Object settingValue) {
        this.settingValue = settingValue;
    }

}