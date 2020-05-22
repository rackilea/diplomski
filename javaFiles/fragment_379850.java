static String format(String format,String...params){
    FormattingTuple ft = MessageFormatter.arrayFormat(format,params);
    String message = ft.getMessage();
    return message;
}

System.out.println(format("hi {}, you {}","there","rock"));