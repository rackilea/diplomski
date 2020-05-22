for(int i = 0; i < studentTests.length; ++i) {
    int score = 0;
    for(int j = 0; j < result.length(); ++j) {
        if(studentTests[i][1].charAt(j) == testAnswers.charAt(j)) {
            ++score;
        } else if(studentTests[i][1].charAt(j) != 'S') {
            --score;
        }
    }
    testScores[i] = score;
}