String input = keyboard.next();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
    simpleDateFormat.setLenient(false);
    Date expiry = simpleDateFormat.parse(input);
    boolean expired = expiry.before(new Date());
    if (expired == true)
    {
        System.out.println("This card has already expired");
    }