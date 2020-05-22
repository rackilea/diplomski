String s = "           here is a $$ cell               here  another         cells I dont care about.........";
String[] res = s.trim().split("\\s{3,}");
if (res.length > 1) {
    System.out.println(res[0]); // Item 1
    System.out.println(res[1]); // Item 2, the rest is unimportant
}