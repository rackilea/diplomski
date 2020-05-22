public void testHash()
{
    System.out.println("A:" + ((int)'A'));
    System.out.println("B:" + ((int)'B'));
    System.out.println("a:" + ((int)'a'));

    System.out.println(hash("Aa".hashCode()));
    System.out.println(hash("BB".hashCode()));
    System.out.println(hash("Aa".hashCode()));
    System.out.println(hash("BB".hashCode()));


    System.out.println(hash("AaAa".hashCode()));
    System.out.println(hash("BBBB".hashCode()));
    System.out.println(hash("AaBB".hashCode()));
    System.out.println(hash("BBAa".hashCode()));

}