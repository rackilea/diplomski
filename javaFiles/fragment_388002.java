import javax.script.*;

  String str="index==1";
  int index = 1;

  try {

    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");
    engine.put("index", index); //set  index as variable in js
    engine.put("str", str);//set str as variable in js

    Boolean result = (Boolean) engine.eval("result = eval(str)");  //eval function
    System.out.println("=>" + result);  //boolean as result
    if(result) System.out.println("1");

  } catch (Exception e){e.printStackTrace();}