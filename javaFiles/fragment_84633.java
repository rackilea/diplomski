abstract class C
{
    abstract String getStartString();

    public String doSomething()
    {
        String str = this.getStartString();
        str = str.replace("B", "");
        return str;
    }
}