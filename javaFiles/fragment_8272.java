entity Address
{
    streetName  String required,
    apartmentOrHouseNumber  String,
    city    String  required,
    zipcode Long    required,
    state   String,
    country String
}

entity BookCoverType
{
    coverType   String  required
}


entity Author
{
    firstName   String  required,
    lastName    String  required,
    middleName  String,
}

entity Book 
{
    bookName String required,
    bookTitle String    required,
    numberOfPages Integer   required,
}




relationship OneToOne 
{
    //Book{bookCoverType(coverType)} to BookCoverType
    Author{address(streetName)} to Address
}

relationship OneToMany 
{
    BookCoverType{book(bookTitle)} to Book
    Book{author(firstName)} to Author
    Author{book(bookTitle)} to Book

}


microservice * with books

paginate Book with pagination
paginate Author with pagination