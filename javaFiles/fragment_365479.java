printTriangle(4,0)
printTriangle2(4,0)

public static String printTriangle(int num, int step)
{
    if (num == 0) {
        return "";
    } 

    String ast = "";
    for (int i = 0; i < num; i++) {
        ast = ast + "*";
    }
    String sps = "";
    for (int i = 0; i < step; i++) {
        sps = sps + " ";
    }


    System.out.println(sps+ast);
    return printTriangle(num-1, step+1) ;
}