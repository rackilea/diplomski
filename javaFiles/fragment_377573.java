import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileStuff {

    public static Question[] fileAsString(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine(); // get the number of questions
            Question[] questionList = new Question[Integer.parseInt(line)]; // initialize the question array
            String partsDelimiter = br.readLine(); // get the delimiter for the question parts
            String choicesDelimiter = br.readLine(); // get the delimiter for the choices
            String answersDelimiter = br.readLine(); // get the delimiter for the answers
            int questionNumber = 0; // initialize the question number
            while ((line = br.readLine()) != null) { // loop through the file to get the questions
                if (!line.trim().isEmpty()) {
                    String[] questionParts = line.split(partsDelimiter); // split the line to get the parts of the
                                                                            // question
                    String question = questionParts[0]; // get the question
                    String[] choices = questionParts[1].split(choicesDelimiter); // get the choices
                    String[] answers = questionParts[2].split(answersDelimiter); // get the answers
                    Question q = new Question(question, choices, answers); // declare and initialize the question
                    questionList[questionNumber] = q; // add the question to the question list
                    questionNumber++; // increment the question number
                }
            }
            br.close();

            return questionList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}