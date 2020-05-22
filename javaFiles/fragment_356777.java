public class Flashcard {

    public enum Difficulty
    {
        Easiest,
        Easy,
        MediumEasy,
        Medium,
        MediumDifficult,
        Difficult,
        MostDifficult
    }

    String question;
    String answer;
    String pathToImageFile;

    Difficulty difficulty;

}