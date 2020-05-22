List<String> strings = ... result from above
   List<Question> questionlists = new ArrayList<Question>();

    for (String object : strings) 
    {
        questionlists.add(object != null ? object.toQuestion() : null);
    }