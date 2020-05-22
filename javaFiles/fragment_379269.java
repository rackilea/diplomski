private void ifstatement() {
    match('I');
    comprsn();
    match('@');
    statement();
    if (token() == '%') {
        statement();
    }
    if (token() != '&') {
        syntax_error("'&' expected");
    }
}