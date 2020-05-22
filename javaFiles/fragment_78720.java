Pattern p = Pattern.compile("\\$\\{([0-9a-zA-Z.@]+)}");  
Matcher m = p.matcher(label);

if(m.find())
{
     String var = m.group();
     String envVar = var.replace("${","").replace("}","");
     label = label.replace(var,System.getenv(envVar));
}