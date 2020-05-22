for (PlayerDefaults pd : pds)
    {
        System.out.println("Name before> " + pd.name());
        System.out.println("TEST BEFORE> " + pd.value);
    }
    PlayerDefaults.Name.value = name;
    for (PlayerDefaults pd : pds)
    {
        System.out.println("Name after> " + pd.name());
        System.out.println("TEST AFTER> " + pd.value);
    }