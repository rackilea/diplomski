int howManyParametersFromCommandLine = getnoParameterCount;  //it will maintain no.of parameters passed from command line

           String[] parametersFromCommandLine  = getParametersFromcommandLine();  // Ex : {1,"ABC",new Double(80.0d)}; 

            List<Class>  parameterTypesList = parseParameters(parametersFromCommandLine); //This will identify type of each of the parameter


   Class  clazz = Class.forName("youClassName");

   Constructor[]  cons = clazz.getConstructors();

   for(Constructor c :  cons)