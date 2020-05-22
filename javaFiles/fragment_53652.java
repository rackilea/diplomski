class Program
{ 
    public static void Main(String[] args)
    {
        Action wish = () => Console.WriteLine("output: hello how r u");
        wish();
    }  
}