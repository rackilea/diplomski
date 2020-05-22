Context rhino = Context.enter();
Object[] functionParams = new Object[] {"Other parameters",new Storage()};
rhino.setOptimizationLevel(-1);
try 
{
 Scriptable scope = rhino.initStandardObjects();
 String rhinoLog = "var log = Packages.io.vec.ScriptAPI.log;";
 String code = /*Javascript code here* as shown separately below/;
 rhino.evaluateString(scope, rhinoLog + code, "ScriptAPI", 1, null);
 Function function = (Function) scope.get("jsFunction", scope);
 Object jsResult = function.call(rhino,scope,scope,functionParams);
}