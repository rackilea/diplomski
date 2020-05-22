try
{
    Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 -W 250 " + address.getHostAddress());
    int returnVal = p1.waitFor();
    boolean reachable = (returnVal==0);


    if(reachable)
        nodes.add(new Node(address.getHostAddress(), false));
}catch(Exception e)
{
    new Node(address.getHostAddress(), true);
}