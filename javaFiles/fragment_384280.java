...
public static final int USE_FIRST = 0;
public static final int USE_SECOND = 1;


...
public Question getQuestion(final int mode, final int nr) {
    ArrayList<Question> listToUse = null;
    if (mode == USE_FIRST) {
         listToUse = mQuestions1;
    } else if (mode == USE_SECOND) {
         listToUse = mQuestions2;
    }
    for (Question q : listToUse) ...
}