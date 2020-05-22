Collection<LoginDetails> details = new ArrayList<LoginDetails>();
    while(rs.next()){
        LoginDetails lds=new LoginDetails();
        lds.setUsername(rs.getString(1));
        lds.setPassword(rs.getString(2));
        lds.setUsertype(rs.getString(3));
        lds.setActive(rs.getString(4));
        details.add(lds);

    }
    return details.toArray(new LoginDetails[0]);