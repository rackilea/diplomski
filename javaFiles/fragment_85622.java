if(parameterTypes.length == howManyParametersFromCommandLine)

       {
          //try to match the parameter type in parameterTypesList with parameterTypes if this matches then

           boolean typeMatchingAndSequecneSucess = matchParameters(parameterTypes,parameterTypesList);

           if(typeMatchingAndSequecneSucess)
           {
               if(c.isAccessible())
               {
                  Object[] initargs = parseAndRetActualParamValue(parametersFromCommandLine); 
                  return c.newInstance(initargs); 
               }
           }
       }

   }