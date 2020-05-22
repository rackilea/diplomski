public enum Question {
    QUESTION_1 {
        @Override public String getText() {
            return "This is the text for Question #1.";
        }
    },

    QUESTION_2 {
        @Override public String getText() {
            return "This is the text for Question #2.";
        }
    },
    :
    :

    QUESTION_N {
        @Override public String getText() {
            return "This is the text for the final question in the series.";
        }
    };

    public abstract String getText();
}