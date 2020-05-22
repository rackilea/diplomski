if ( !length(s) )
{
    //stop the recursion
    return;
}
else 
{
    printBackwards(rest(s));
}