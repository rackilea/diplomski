public class UserInformation {
    private String Name;
    private String Gender;
    private String Email;
    private String Birthday;

    public UserInformation(String Name,String Gender,String Email,String Birthday){
        this.Birthday=Birthday;
        this.Email=Email;
        this.Gender=Gender;
        this.Name=Name;
    }

    public String getName(){return Name;}
    public String getEmail(){return Email;}
    public String getGender(){return Gender;}
    public String getBirthday(){return Birthday;}