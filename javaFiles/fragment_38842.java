// prints "Not Found"
System.out.println(HttpStatus.CODE_404.getDescription());

// prints "Internal Server Error"
System.out.println(HttpStatus.CODE_500.getDescription());

// compiler throws an error for the "123" being an invalid symbol.
System.out.println(HttpStatus.CODE_123.getDescription());