List<Question> questionlists = task.execute(myitem).get();
   List<String> strings = new ArrayList<String>();

    for (Question object : questionlists) 
    {
        strings.add(object != null ? object.toString() : null);
    }