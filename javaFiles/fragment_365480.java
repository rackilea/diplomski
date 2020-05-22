public static String printTriangle2(int num, int step)
{
    if (num == 0) {
        return "";
    } 

    String ast = "";
    for (int i = 0; i <= step; i++) {
        ast = ast + "*";
    }
    String sps = "";
    for (int i = 0; i < num; i++) {
        sps = sps + " ";
    }


    System.out.println(sps+ast);
    return printTriangle2(num-1, step+1) ;
}