@State(
        name = "Test", storages = {
        @Storage(
                id = "other",
                file = "$APP_CONFIG$/testpersist.xml")
})
public class Test implements PersistentStateComponent<Test> {

    String ceva;

    public Test() {
        ceva = "sad";
        System.out.println("constr");
    }

    public String getCeva() {
        return ceva;
    }

    public void setCeva(String ceva) {
        this.ceva = ceva;
    }

    public void loadState(Test state) {
        System.out.println("cstate load");

        XmlSerializerUtil.copyBean(state, this);
    }

    public Test getState() {
        System.out.println("cstate retu");
        return this;
    }
}