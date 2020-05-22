Runtime runtime = Runtime.getRuntime();
try
{
    runtime.exec("service call phone 5 \n");
}
catch (Exception e)
{
    e.printStackTrace();
}