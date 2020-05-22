try
    try 
        fn();
    catch (GException exc)
        g();
    catch (HException exc)
        h();
catch (IException exc)
    i();