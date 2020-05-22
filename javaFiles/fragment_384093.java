public class MemberDetails{

    private String planId;

    @XMLElement(required=true)
    public String getPlanId() {
        return planId;
    }
}