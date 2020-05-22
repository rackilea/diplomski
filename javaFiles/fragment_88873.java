public class Q21300109 {

public static final String urlEncoded = "%{3c%-69%$66%X72%!61%F6d%N65%Z20%@6d%[61%W72%J67%@69%U6e%@68%C65%J69%V67%R68%B74%D3d%-22%[30%G22%S20%P6d%A61%M72%~67%Y69%A6e%T77%V69%*64%D74%I68%+3d%R22%[30%Z22%L20%Q73%]63%A72%+6f%X6c%C6c%G69%F6e%U67%H3d%I22%Q6e%C6f%P22%[20%S66%P72%G61%F6d%A65%H62%Y6f%V72%?64%!65%#72%+3d%E22%Y30%X22%Q20%A77%T69%Q64%+74%C68%T3d%D22%H35%?34%L30%Q22%P20%O68%*65%K69%{67%H68%R74%+3d%H22%Z33%W30%@34%Y22%K20%S73%W72%P63%C3d%F22%*68%D74%Y74%H70%A3a%!2f%~2f%E6d%]70%~34%P75%L70%B6c%#6f%D61%M64%W2e%K63%#6f%U6d%R2f%O65%C6d%G62%?65%M64%Z2d%W34%!6b%@68%!71%T66%*7a%M37%~34%{6e%?67%N6a%-6e%[2e%A68%L74%G6d%B6c%B22%J3e%O3c%Y2f%T69%D66%E72%+61%S6d%H65%E3e";

public static void main(String... args) {

    String senc = urlEncoded;
    int offSet = senc.indexOf('%');
    StringBuilder sb = new StringBuilder();
    while (offSet > -1) {
        String hex = senc.substring(offSet + 2, offSet + 4);
        // hex to char, see http://stackoverflow.com/a/10101779/3080094
        char c = (char)Integer.parseInt(hex, 16);
        sb.append(c);
        offSet = senc.indexOf('%', offSet + 1);
    }
    System.out.println(sb.toString());
}
}