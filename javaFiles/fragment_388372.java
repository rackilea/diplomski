public static void winner() {
  StringBuilder out = new StringBuilder("THE WINNER IS ");
  if (position1 >= 100) {
    out.append(name1);
  } else if (position2 >= 100 {
    out.append(name2);
  } else {
    return; // Preserve previous behavior just in case, remove this if it's not needed
  }
  System.out.println(out);
}