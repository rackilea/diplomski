private void test(){
        Map<String, List<String>> categories = new HashMap<>();
        String answerFromClient = "Some text";
        List<String> actionAnswers = categories.get("action");
        if (actionAnswers == null){
            actionAnswers = new ArrayList<>();
            actionAnswers.add(answerFromClient);
            categories.put("action",actionAnswers);
        }
        else{
            actionAnswers.add(answerFromClient);
        }
    }