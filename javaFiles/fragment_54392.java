public String checkIn(Book b){
    for(int i = 0; i < books.length; i++){
        if(b.equals(books[i])){
            if(checkedOut[i] > 0){
                checkedOut[i]--;
                return "Checked in!";
            }else{
                return "All of our copies are already checked in.";
            }

        }else{
            return "Book not found.";
        }
    }
    return "";
}