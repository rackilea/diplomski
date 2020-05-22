public class ImagedScore {
    private final int guessesLeft;
    private final Image image;
    //getters&constructor
}

public class MainClass {
    ImagedScore[] imagedScoreArray;
    //constructors, other methods and data, etc.

    updateScore(int score) {
        ImagedScore imagedScore = imagedScoreArray[score];
        //checks or other way to find proper ImagedScore object
        this.score = score;
        this.image = imagedScore.getImage;
    }
}