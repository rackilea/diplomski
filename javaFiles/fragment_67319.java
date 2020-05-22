public class ProfessorConverter extends StringConverter<Professor> {

     @Override
     public Professor fromString(String professorAsString) {
         // Create a professor from a string, e.g. (assuming that
         // the professorAsString as the form "1 John Doe"
         String[] pieces = professorAsString.split(" ");
         return new Professor(pieces[0], pieces[1], pieces[2]);
     }

     @Override
     public String toString(Professor professor) {
         // Converts your professor to a String of type "John Doe"
         return professor.getFirstName() + " " + professor.getLastName();
     }

}