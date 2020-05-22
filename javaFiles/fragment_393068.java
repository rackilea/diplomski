...

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter which class:");
JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
className=br.readLine()
int results = compiler.run(null, null, null, className+".java");
if(results == 0){

    Class clazz = Class.forName(className+".class");
    System.out.print("Compiled successfully.Enter which method:");
    Object returnValue=clazz.getMethod(br.readLine()).invoke(null);
}
...