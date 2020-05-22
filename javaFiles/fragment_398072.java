char * find_type(char *str,int *type){
    str = trim_leading_space(str);
    if(*str == SLASH_SIGN){
        str++;
    }else{
        display_error(BAD_TYPE_FORMAT, str);
    }
    str = trim_leading_space(str);
    *type = convert_to_zero_or_one(str[0]);
    if(*type == NO){
        display_error(BAD_TYPE_FORMAT, str);
    }else {
        str++;
    }

    return str;
}