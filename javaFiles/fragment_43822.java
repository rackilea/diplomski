public class MyData {
    private String fullname;
    private String skype;
    private String github;

    public MyData(String fullname, String skype, String github) {
        this.fullname = fullname;
        this.skype = skype;
        this.github = github;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getSkype() {
        return this.skype;
    }

    public String getGithub() {
        return this.github;
    }

    public String[] cutName(String string) {
        return string.split(" ");
    }

    @Override
    public String toString() {
        return "Fullname: " + this.fullname + "; Skype: " + this.skype + "; Github: " + this.github;
    }

    public static void main(String[] args) {
        MyData myData = new MyData("Mimi Rudolph", "minirudolph_skype", "minirudolph_githnub");
        System.out.println("First name: " + myData.cutName(myData.getFullname())[0]);
        System.out.println("Last name: " + myData.cutName(myData.getFullname())[1]);
        System.out.println(myData);
    }
}