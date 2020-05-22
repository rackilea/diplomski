int postcode = 3000;
    String service = "Emergency";

    StringBuilder sb = new StringBuilder(); 
        sb.append("SELECT * FROM Hospital WHERE Postcode = ");
        sb.append(postcode);
        sb.append("AND Hospital_id IN SELECT Hospital_id FROM Hospital_Medical hm INNER JOIN "
                + "Medical_Service m ON hm.Medical_id = m.Medical_id where Medical_name = '");
        sb.append(service);
        sb.append("')");

    String queryString = sb.toString();
    Query query = em.createNativeQuery(queryString);
    List<Hospital> result = query.getResultList();