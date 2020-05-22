String actions[] = new String[5];
for (i = 0; i < 5; i++)
        actions[i] = request.getParameter("Actions["+i+"]");

String[][] subActions = new String[5][];
    for (i = 0; i < length; i++) 
        subActions[i] = request.getParameterValues("SubActions["+i+"]");