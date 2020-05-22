public static String streamAppend(Iterable<Character> chars){
    return StreamSupport.stream(chars.spliterator(), true)
                        .collect(
                            StringBuilder::new,
                            StringBuilder::append,
                            StringBuilder::append
                         )
                        .toString();
}