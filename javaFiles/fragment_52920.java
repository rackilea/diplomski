// prepare the query
String query = "INSERT INTO users (
                        category_questions, 
                        questions, 
                        quest_opt_a,
                        quest_opt_b, 
                        quest_opt_c,  
                        quest_opt_d, 
                        correct_option_answer 
                 ) VALUES (?, ?, ?, ?, ?, ?, ?)"; 

// load the file
Scanner scanner = new Scanner(filename);
// read the file line by line
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();

    String[] questionAnswer = line.split("?")[ // line.split["?"] will split the line into two strings, right at the ? and put those two strings into an array. 
    String question = questionAnswer[0]  // so [0] will access the first element in that array - the question 
    String[] answers = questionAnswer[1].split(","); // now we split the string after the ? into many strings divided by comma

    preparedStmt.setString(1, "JDBC");   
    preparedStmt.setString(2, question);  
    preparedStmt.setString(3, answers[0]);     
    preparedStmt.setString(4, answers[1]);      
    preparedStmt.setString(5, answers[2]);       
    preparedStmt.setString(6, answers[3]);      
    preparedStmt.setString(7, answers[4]);      

    preparedStmt.executeUpdate();
}