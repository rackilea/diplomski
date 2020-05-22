public class Vocable
{

    private final String german;
    private final String english;
    private final ReadOnlyIntegerWrapper givenAnswers = new ReadOnlyIntegerWrapper();
    private final ReadOnlyIntegerWrapper correctAnswers = new ReadOnlyIntegerWrapper();
    private final ReadOnlyIntegerWrapper skippedAnswers = new ReadOnlyIntegerWrapper();


    public Vocable(String ger, String eng)
    {
        german = ger;
        english = eng;
        givenAnswers.set(0);
        correctAnswers.set(0);
        skippedAnswers.set(0);
    }

    public String getGerman()
    {
        return german;
    }

    public String getEnglish()
    {
        return english;
    }

    public ReadOnlyIntegerProperty givenAnswersProperty() {
        return givenAnswers.getReadOnlyProperty() ;
    }

    public final int getGivenAnswers() 
    {
        return givenAnswersProperty().get();
    }

    public void increaseGivenAnswers() 
    {
        givenAnswers.set(getGivenAnswers()+1);
    }


    public ReadOnlyIntegerProperty correctAnswersProperty() {
        return correctAnswers.getReadOnlyProperty();
    }

    public final int getCorrectAnswers() 
    {
        return correctAnswersProperty().get();
    }

    public void increaseCorrectAnswers() 
    {
        this.correctAnswers.set(getCorrectAnswers()+1);
    }

    public ReadOnlyIntegerProperty skippedAnswersProperty() {
        return skippedAnswers.getReadOnlyProperty();
    }

    public final int getSkippedAnswers() 
    {
        return skippedAnswersProperty().get();
    }

    public void increaseSkippedAnswers() 
    {
        this.skippedAnswers.set(getSkippedAnswers()+1);
    }

}