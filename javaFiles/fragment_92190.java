public class HabilitationAD {

    @SerializedName("Key")
    private String mKey;

    @SerializedName("Value")
    private List<BeanHabilitation> mValue;

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }

    public List<BeanHabilitation> getmValue() {
        return mValue;
    }

    public void setmValue(List<BeanHabilitation> mValue) {
        this.mValue = mValue;
    }

    public HabilitationAD(){

    }

    public HabilitationAD(String p_mKey, List<BeanHabilitation> p_mValue){
        this.mKey = p_mKey;
        this.mValue = p_mValue;
    }
}