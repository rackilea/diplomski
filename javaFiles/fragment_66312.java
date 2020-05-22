Question question1 = new Question();
    question1.setQname("What is Java?");

    Question question2 = new Question();
    question2.setQname("What is Servlet?");

    session.persist(question1);
    session.persist(question2);

    Answer ans1 = new Answer();
    ans1.setAnswername("java is a programming language");
    ans1.setPostedBy("Ravi Malik");
    ans1.setQuestion(question1);

    Answer ans2 = new Answer();
    ans2.setAnswername("java is a platform");
    ans2.setPostedBy("Sudhir Kumar");
    ans2.setQuestion(question1);

    Answer ans3 = new Answer();
    ans3.setAnswername("Servlet is an Interface");
    ans3.setPostedBy("Jai Kumar");
    ans3.setQuestion(question2);

    Answer ans4 = new Answer();
    ans4.setAnswername("Servlet is an API");
    ans4.setPostedBy("Arun");
    ans4.setQuestion(question2);

    session.persist(ans1);
    session.persist(ans2);
    session.persist(ans3);
    session.persist(ans4);