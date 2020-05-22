//Open JPA session
        javax.persistence.EntityManagerFactory emf=javax.persistence.Persistence.createEntityManagerFactory("manager1");
        javax.persistence.EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        //Make a FullText EM from the JPA session.
        org.hibernate.search.jpa.FullTextEntityManager fullTextSession=org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        //Build the lucene query.
        org.apache.lucene.queryParser.QueryParser parser=new org.apache.lucene.queryParser.QueryParser("data1",new org.apache.lucene.analysis.standard.StandardAnalyzer());
        org.apache.lucene.search.Query query=parser.parse("FindMe");

        //Convert to a hibernate query.
        org.hibernate.search.jpa.FullTextQuery query2=fullTextSession.createFullTextQuery(query, SampleBean.class);

        //Set the projections
        query2.setProjection("id");

        //Run the query.
        for (Object[] row:(List)query2.getResultList()){
            //Show the list of id's
            System.out.println(row[0]);
        }

        //Close
        em.getTransaction().commit();
        em.close();
        emf.close();