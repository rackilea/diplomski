List<Object[]> list = sessionFactory.getCurrentSession()
        .createQuery("from Vote as v left join v.message as m " +
                "where m.question=:question and v.user=:user and v.voteType=:voteType")
        .setParameter("question", question)
        .setParameter("user", user)
        .setParameter("voteType", VoteType.MESSAGE)
        .list();
System.out.println(list.get(0)[0].getMessage().getNumber());