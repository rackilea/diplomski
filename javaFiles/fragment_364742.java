public static void main(String[] args)
{
    String[] tests = {
            "This is a short string",
            "This sentence has a space at chr 36 so is a good test",
            "I often used to look out of the window, but I rarely do that anymore, even though I liked it",
            "I live in Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch",
    };

    int limit = 36;
    for(String s : tests)
    {
        List<String> chunks = chunk(s, limit);
        for(String st : chunks)
            System.out.println("|" + st + "|");
        System.out.println();
    }
}