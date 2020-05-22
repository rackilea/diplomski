String text = "a;b;c;d;<x;y;z>;e;f;g;<p;q;r;s>;h;i;j";

String[] parts = text.split(";(?![^<>]*>)");

System.out.println(java.util.Arrays.toString(parts));
//  _  _  _  _  _______  _  _  _  _________  _  _  _
// [a, b, c, d, <x;y;z>, e, f, g, <p;q;r;s>, h, i, j]