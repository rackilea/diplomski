public class goToUserProfile {
    private Long userNo;
    public Long getUserNo(){
        return this.userNo
    }
    public void setUserNo(String rhs){
        this.userNo;
    }
    public String execute(){
        System.out.println("An action class has been called!");
        return "profile";
    }
}