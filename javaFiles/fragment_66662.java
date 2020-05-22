double single = 0;
    double doublee = 0;
    for (Portfolio pobj : portfolios) {
        if(pobj.scoringRule.equals("single"))
            single++;
        else
            doublee++;
    }
    System.out.println("single Percentage : " +(single / list.size() )*100);
    System.out.println("doublee Percentage : " + (doublee / list.size())*100);