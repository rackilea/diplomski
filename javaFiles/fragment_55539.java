String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + "<User>\n"
        + "    <?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + "    <User>\n"
        + "        <objectId>c33edcd9-5c13-4ceb-a81a-0a8f44b813ed</objectId>\n" + "    </User>\n"
        + "    <?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + "    <User>\n"
        + "        <objectId>c33edcd9-5c13-4ceb-a81a-0a8f44b813ed</objectId>\n" + "    </User>\n"
        + "</User>";

System.out.println("Before: " + s);
System.out.println("After: " + s.replaceAll("\\s+<\\?xml\\s+version=\"1.0\".*", ""));