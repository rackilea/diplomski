public static String tlv(String str1)
{
    String slim="";
    String str=str1+"00";
    int tlvlen=0;
    while(str.substring(tlvlen+0,tlvlen+2).matches("AA|A4|A9|1E|C0|C1|C2|C3|C4|C5|C6|C7|C8|C9|CA|CB|CC|A8|A0|4F|50|51|52|53|54|61|73|80|81|82|83|84|85|86|87|88|89|95"))
    {
    int len=Convertion.hex2decimal(str.substring(tlvlen+2,tlvlen+4))*2+4;
    String tlv=str.substring(tlvlen,len+tlvlen);
    slim+=tlv+" ";

    tlvlen=tlv.length()+tlvlen;
    }
    return slim;
}