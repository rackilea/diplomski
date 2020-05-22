private static String[] tensNumberNameArray = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
private static String[] singleWordNumberNameArray = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
private static Map<String, String> numberNameMap = new HashMap<>();
static {
    numberNameMap.put("zero", "0");
    numberNameMap.put("one", "1");
    numberNameMap.put("two", "2");
    numberNameMap.put("three", "3");
    numberNameMap.put("four", "4");
    numberNameMap.put("five", "5");
    numberNameMap.put("six", "6");
    numberNameMap.put("seven", "7");
    numberNameMap.put("eight", "8");
    numberNameMap.put("nine", "9");
    numberNameMap.put("ten", "10");
    numberNameMap.put("eleven", "11");
    numberNameMap.put("twelve", "12");
    numberNameMap.put("thirteen", "13");
    numberNameMap.put("fourteen", "14");
    numberNameMap.put("fifteen", "15");
    numberNameMap.put("sixteen", "16");
    numberNameMap.put("seventeen", "17");
    numberNameMap.put("eighteen", "18");
    numberNameMap.put("nineteen", "19");
    numberNameMap.put("twenty", "20");
    numberNameMap.put("thirty", "30");
    numberNameMap.put("forty", "40");
    numberNameMap.put("fifty", "50");
    numberNameMap.put("sixty", "60");
    numberNameMap.put("seventy", "70");
    numberNameMap.put("eighty", "80");
    numberNameMap.put("ninety", "90");
}

public static void main(String[] args) {
    String path = "c:/num.txt";
    try (PrintWriter numberWriter = new PrintWriter(new File(path)); Scanner numberReader = new Scanner(new File(path))) {
        for (int i = 0; i < 10000; i ++) {
            numberWriter.println(numberToSentence(i));
            numberWriter.flush();
        }
        while (numberReader.hasNext()) {
            System.out.println(sentenceToNumber(numberReader.nextLine()));
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}

public static String numberToSentence(Integer num) {
    if (num != 0) {
        if (num > 0 && num < 20) {
            return singleWordNumberNameArray[num];
        } else if (num > 19 && num < 100) {
            return tensNumberNameArray[num / 10] + " " + (num % 10 == 0 ? "" : numberToSentence(num % 10));
        } else if (num > 99 && num < 1000) {
            return singleWordNumberNameArray[num / 100] + " hundred " + (num % 100 == 0 ? "" : "and " + numberToSentence(num % 100));
        } else if (num > 999 && num < 10000) {
            return singleWordNumberNameArray[num / 1000] + " thousand " + (num % 1000 == 0 ? "" : "and " + numberToSentence(num % 1000));
        }
    } else {
        return singleWordNumberNameArray[num];
    }
    return "";
}

public static int sentenceToNumber(String numStr) {
    String[] numParts = numStr.split(" and ");
    StringBuilder integerNum = new StringBuilder("");
    for (String part : numParts) {
        String[] partIsParts = part.split(" ");
        if (part.contains("thousand")) {
            integerNum.append(numberNameMap.get(partIsParts[0]));
            integerNum.append("000");

        } else if (part.contains("hundred")) {
            if (integerNum.length() == 0) {
                integerNum.append(numberNameMap.get(partIsParts[0]) + "00");
            } else {
                integerNum.setCharAt(integerNum.length() - 3, numberNameMap.get(partIsParts[0]).charAt(0));
            }
        } else {
            if (integerNum.length() == 0) {
                if (part.split(" ").length == 2) {
                    integerNum.append(numberNameMap.get(partIsParts[0]));
                    integerNum.setCharAt(integerNum.length() - 1, numberNameMap.get(partIsParts[1]).charAt(0));
                } else {
                    integerNum.append(numberNameMap.get(partIsParts[0]));
                }

            } else if (part.split(" ").length == 2) {
                integerNum.setCharAt(integerNum.length() - 2, numberNameMap.get(partIsParts[0]).charAt(0));
                integerNum.setCharAt(integerNum.length() - 1, numberNameMap.get(partIsParts[1]).charAt(0));

            } else if ("zero one two three four five six seven eight nine".contains(part)) {
                integerNum.deleteCharAt(integerNum.length() - 1);
                integerNum.append(numberNameMap.get(partIsParts[0]));
            } else {
                integerNum.deleteCharAt(integerNum.length() - 1);
                integerNum.deleteCharAt(integerNum.length() - 1);
                integerNum.append(numberNameMap.get(partIsParts[0]));
            }
        }
    }
    return Integer.parseInt(integerNum.toString());
}