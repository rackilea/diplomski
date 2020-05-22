try (Scanner input = new Scanner(System.in)) {
  System.out.print("Unesite rec koju trazite");
  final Elements result = Jsoup.connect("http://www.b92.net").get()
        .select("a[href]:contains(" + input.next() + ")");
  System.out.println(result.size() > 0?
      result.get(0).attr("href") : "nema rezultata");
}