import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SOTest {

    public static void main(String[] args) {
        try {
            String inputJson = "[\r\n" + 
                    "{\"firstName\":\"Chelsea\",\"surname\":\"Ganter\",\"dob\":\"29/03/2005\",\"scoutNumber\":\"181812\",\"joiningDate\":\"01/09/2016\"},\r\n" + 
                    "{\"firstName\":\"Oliver\",\"surname\":\"Greenhatch\",\"dob\":\"10/09/2007\",\"scoutNumber\":\"268981\",\"joiningDate\":\"17/07/2019\"}\r\n" + 
                    "]";
            com.fasterxml.jackson.databind.ObjectMapper mapper  = new ObjectMapper();

            Profile[] profiles = mapper.readValue(inputJson, Profile[].class);
            System.out.println(Arrays.asList(profiles));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Profile{
    private String firstName;

    private String surname;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dob;

    private int scoutNumber;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date joiningDate;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public int getScoutNumber() {
        return scoutNumber;
    }
    public void setScoutNumber(int scoutNumber) {
        this.scoutNumber = scoutNumber;
    }
    @Override
    public String toString() {
        return "Profile [firstName=" + firstName + ", surname=" + surname + ", dob=" + dob + ", scoutNumber="
                + scoutNumber + ", joiningDate=" + joiningDate + "]";
    }

}