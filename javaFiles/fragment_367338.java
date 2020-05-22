Customer c=null;    
if(rs.next()){
    c = new Customer(rs.getString("username"), rs.getString("name"), rs.getString("email"),
     rs.getString("address"), rs.getString("creditCardDetails"), rs.getString("password"));

}
if(null != c && c.getUsername().contains(user))
            return c;
        else
            return null;