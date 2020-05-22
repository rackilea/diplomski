Collections.sort(questionlist, new Comparator<Question>() {

    @Override
    public int compare(Question q1, Question q2) {
        String q1NumParts[] = q1.getQuestionNumber().split("\\.");
        String q2NumParts[] = q2.getQuestionNumber().split("\\.");
        if (Integer.parseInt(q1NumParts[0]) > Integer.parseInt(q2NumParts[0])) {
            return 1;
        } else if (Integer.parseInt(q1NumParts[0]) < Integer.parseInt(q2NumParts[0])) {
            return -1;
        } else {
            if (Integer.parseInt(q1NumParts[1]) > Integer.parseInt(q2NumParts[1])) {
                return 1;
            } else if (Integer.parseInt(q1NumParts[1]) < Integer.parseInt(q2NumParts[1])) {
                return -1;
            }
        }
        return 0;
    }
});