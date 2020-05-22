$ jshell --class-path .:~/scala-2.13.0/lib/scala-library.jar 
|  Welcome to JShell -- Version 11.0.3
|  For an introduction type: /help intro

jshell> Map<String, String> vs = scala.jdk.javaapi.CollectionConverters.asJava(new mytools.MapMaker().m())
vs ==> {greeting=hi, reply=bye}