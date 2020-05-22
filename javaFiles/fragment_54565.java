class Person {
    String name;
    String age;
    Answer[] answers;
}

class Survey {
    Question[] listOfQuestions;
}

class Question {
    String questionString;
    Answer[] answers;
}

class Answer {
    Person person;
    Question question;
    String answer;
}