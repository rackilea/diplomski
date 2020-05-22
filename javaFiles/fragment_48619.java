ParseQuery<ParseObject> query = ParseQuery.getQuery("Question");
query.getInBackground(questionId, new GetCallback<ParseObject>() {
    @Override
    public void done(ParseObject object, ParseException e) {
        if(e==null){
            queryAnswers(object);
        } else {
            System.out.println(e);
        }

    }
});

private void queryAnswers(ParseObject question) {
    ParseQuery<ParseObject> answerQuery = ParseQuery.getQuery("Answers");
    answerQuery.whereEqualTo("Question", question);
    answerQuery.findInBackground(new FindCallback<ParseObject>() {
        @Override
        public void done(List<ParseObject> answers, ParseException e) {
            if(e==null){
                // do what you want with the answers...
            } else {
                System.out.println(e);
            }

        }
    });
}