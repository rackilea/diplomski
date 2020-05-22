if(books==null) throw new IllegalArgumentException();

for (int i = 0; i < books.length; i++){
   if(books[i] != null){
        total += books[i].getPrice();
   }
}