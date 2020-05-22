if (x.contains(".")) 
{
    // set the max length to be 15

    if (x.indexOf(".") > 9)
    {
        txt.setText(x.substring(0,9));   
        // set length to be 9
    }
}
else
{
    // set max length back to original
}