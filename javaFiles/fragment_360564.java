List<String> list = Arrays.asList(
new String[]{
    "10/02/1992 or 1992",
    "10/02/1992",
    "10/1992",
    "02/1992",
    "1992",
    "1234 5694 7487"

    }
);

String regex = ".*?(?:(?:[0-9]{2}[/-]){2}[0-9]{4}|[0-9]{4}(?:\\h[0-9]{4}){2}).*";

for (String str: list) {
    if (str.matches(regex)){
        System.out.println(str);
    }
}