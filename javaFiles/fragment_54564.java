class Person {
    String name;
    String age;
}

class Survey {
    Question[] listOfQuestions;
}

class Question {
    String questionString;
    Person person;
    Answer[] answers;
}

class Answer {
    Person person;
    String answer;
}