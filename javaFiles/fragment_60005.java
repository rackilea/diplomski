String input = "ADITYA";
    List<String> coreTeam = Arrays.asList("ASHISH","ADITYA","SUMANT","SHASHIKANT","HATIM");

    System.out.println(coreTeam.toString());

    StandardEvaluationContext coreTeamContext = new StandardEvaluationContext(coreTeam);
    coreTeamContext.setVariable("CORE_TEAM",coreTeam);
    coreTeamContext.setVariable("CHEK_TEAM",input);

    Expression exp40 = parser.parseExpression("#CORE_TEAM.contains(#CHEK_TEAM)");
    Boolean s = exp40.getValue(coreTeamContext,Boolean.class);