URLEncoder.encode(password, CHARSET) 

/**
* This class is used to encode a string using the format required by
* {@code application/x-www-form-urlencoded} MIME content type.
*
* <p>All characters except letters ('a'..'z', 'A'..'Z') and numbers ('0'..'9')
* and characters '.', '-', '*', '_' are converted into their hexadecimal value
* prepended by '%'. For example: '#' -> %23. In addition, spaces are
* substituted by '+'.
*/