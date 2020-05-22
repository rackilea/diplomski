public static void main(String args) {
  boolean numeric = false;

  if (numeric) {
    Trolley<Integer> trolley = new Trolley<>();
    trolley.addItem(42);
  } else {
    Trolley<String> trolley = new Trolley<>();
    trolley.addItem("42");
  }
}