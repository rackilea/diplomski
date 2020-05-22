public class Profile {

    private String name;
    private String dayOfBirth;
    private String townOfResidence;
    private String counrtyOfResidence;
    private String nationality;
    private String listOfInterests;
    private Profile listOfFriends;

    public Profile(String name, String dateOfBirth, String townOfResidence, String
            counrtyOfResidence, String nationality, String listOfInterests
            , Profile listOfFriends) {

        this.name = name;
        this.dayOfBirth = dateOfBirth;
        this.townOfResidence = townOfResidence;
        this.counrtyOfResidence = counrtyOfResidence;
        this.nationality = nationality;
        this.listOfInterests = listOfInterests;
        this.listOfFriends = listOfFriends;
    }

    public String getName() {
        return name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;

    }

    public void setTownOfResidence(String town) {
        this.townOfResidence = town;
    }

    public String getTownOfResidence() {
        return townOfResidence;
    }

    public void setNationality(String Nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setlistOfInterests(String interests) {
        this.listOfInterests = interests;
    }

    public String getlistOfInterests() {
        return listOfInterests;

    }

    public void setCounrtyOfResidence(String country) {
        this.counrtyOfResidence = country;
    }

    public String getCounrtyOfResidence() {
        return counrtyOfResidence;
    }
}