public static SomeInterface getInterface()
{               
    SomeInterface res = new JavaSomeInterfaceImpl();

    if (System.getProperty("os.name").matches(".*Windows.*"))
    {
        File library = new File("mylibrary.dll");
        System.load(library.getAbsolutePath());
        res = new NativeSomeInterfaceImpl();
    }

    return res; 
}