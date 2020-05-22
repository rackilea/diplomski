Intent i;
    PackageManager manager = getPackageManager();
    try 
    {
        i.addFlags(0);
        i.setPackage(null);

        if (i == null)
            throw new PackageManager.NameNotFoundException();

        startActivity(i);

    } 
    catch (PackageManager.NameNotFoundException e) 
    {
    }