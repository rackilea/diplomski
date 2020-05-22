List<String> expMsg = Arrays.asList("Line1", "Line2", "Line3", "Line4", "Line5", "Line6");

String actMsg = "Line1.\n"
                + "Line3\n"
                + "Line2\n"
                + "Line5\n"
                + "Line4\n" + "\n"
                + "Line6.";

boolean containsAll = expMsg.stream()

                            //select only elements which are in actMsg
                            .filter(actMsg::contains) //e -> actMsg.contains(e)

                            //all strings from expMsg should be present
                            .count() == expMsg.size();


System.out.println(containsAll);