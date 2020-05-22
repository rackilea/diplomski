public class Tutorium {
    private Vorlesung vorlesung;
    // public String tName;  // get rid of
    private int tNumber;



    public String gettName() {
        if (vorlesung != null) {
            return vorlesung.getlecturer();
        }

        return null; // or throw exception
    }

    // *** get rid of this since you won't be setting names
    // public void settName(Vorlesung vorlesung) {
    //     this.tName = vorlesung.lectureName;
    // }