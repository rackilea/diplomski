public String getKelamin()
{
    if(sub3.equals("1"))
        kelamin = "Pria";
    else if(sub3.equals("2"))
        kelamin = "Wanita";
    else
        kelamin = "Ganda";
    return kelamin;
}