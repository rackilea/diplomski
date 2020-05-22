List<Integer> markBook = new ArrayList<>();
ArrayList<String> nameBook = new ArrayList<>();
int getMark;
try {
  getMark = Integer.valueOf(markField.getText());
}catch(Exception ex) {
  getMark = 0; //default value if you don't want to give 
               //default the just display error message 
}
markBook.add(getMark);