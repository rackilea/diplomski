try (PreparedStatement pst = con.prepareStatement(query);) {
    pst.setDate(1, startDate);
    pst.setDate(2, endDate);
    //Then Iterate over the agents list and set the values to the placeholders
    for (int i = 0; i < agents.size(); i++) {
        pst.setString(i + 3, agents.get(i));//Why (i+3)? because you already set 2 params
    }

    //get your results
    ResultSet rs = pst.executeQuery();
}