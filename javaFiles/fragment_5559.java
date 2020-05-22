boolean hasNullOrEmptyString = Stream.of(myField1,myField2,...,myFieldN)
                                     .anyMatch(this::isNullOrEmptyString);

boolean isNullOrEmptyString(String it){
  return it==null || it.isEmpty();
}