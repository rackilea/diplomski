String splitMe = "Tinus has 99 issues and has to pay $2200.50 for 26 on 2016/10/10";
String[] parts = splitMe.split(" ");
List<String> textList = new ArrayList<>();
List<String> numbersList = new ArrayList<>();
List<String> currencyList = new ArrayList<>();
List<String> dateList = new ArrayList<>();

for (String part : parts) {
    if (part.matches("\\d*")) {
        numbersList.add(part);
    }
    else if (part.matches("\\$\\d*\\.\\d*")) {
        currencyList.add(part);
    }
    else if (part.matches("\\d{4}/\\d{2}/\\d{2}")) {
        dateList.add(part);
    }
    else {
        textList.add(part);
    }
}