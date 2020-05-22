char op = '*';
String operand1= "10";
String operand2 = "20";
ScriptEngineManager scm = new ScriptEngineManager();
ScriptEngine jsEngine = scm.getEngineByName("JavaScript");

System.out.println(jsEngine.eval(operand1+op+operand2));