@Test
public void findRing() {
    System.out.println(Arrays.toString(findRing("squirrel", "eyes", "klondlike", "lasik")));
    System.out.println(Arrays.toString(findRing("why", "cant", "we", "dance")));
    System.out.println(Arrays.toString(findRing("apple", "tampa", "elephant")));
    System.out.println(Arrays.toString(findRing("apple", "elephant", "tampa")));
    System.out.println(Arrays.toString(findRing("elephant", "apple", "tampa")));
    System.out.println(Arrays.toString(findRing("alfa", "alfa", "beta")));
    System.out.println(Arrays.toString(findRing("alfa", "alfa")));
    System.out.println(Arrays.toString(findRing("alfa", "alfa", "bravo")));
}