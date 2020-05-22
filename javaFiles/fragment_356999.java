char[] correctAnswers = {'E', 'A', 'D', 'C', 'C'};
char[][] studentAnswers = {{'E', 'A', 'D', 'B', 'C'}, {'d', 'a', 'd', 'e', 'c'}, {'b', 'a', ' ', 'e', 'a'}};

int answersNumber = correctAnswers.length;
int[] correctStudentAnswers = new int[answersNumber];

for (char[] studentAnswer : studentAnswers) {
    for (int i = 0; i < answersNumber; i++) {
        if (Character.toUpperCase(studentAnswer[i]) == correctAnswers[i]) {
            correctStudentAnswers[i]++;
        }
    }
}

System.out.println(Arrays.toString(correctStudentAnswers));