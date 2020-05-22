String compiler = "";

switch(compilerCode)
{
    case JAVA:
        compiler = "javac";
    break;
    case C:
        compiler = "javac";
    break;

    ...
 }


 Process p = Runtime.getRuntime().exec(compiler + " " + file);
 p.waitFor();