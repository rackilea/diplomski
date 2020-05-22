String day = "fr|sa|su|mo|tu|we|th";
String pattern = "(?!.*\\b([a-z]{2})\\b.*\\b\\1\\b)(?:" + day + ")?(?:,(?:" + day + ")){0,5}";
if (s.matches(pattern)) {
    System.out.println("Valid!");
} else {
    System.out.println("Invalid!");
}