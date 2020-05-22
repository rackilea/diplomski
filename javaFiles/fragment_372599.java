public final class ProblemFactory {

    public static Problem createProblem(){
        long random = Math.round((Math.random() * 4) + 1);
        switch(random) {
            case 1:
                return new AdditionProblem();
            case 2:
                return new SubtractionProblem();
                ...
    }
}

public interface Problem {

    public String getProblem();

    public String getAnswer();

}