public String excelFormula(String d3, int i3, String r3, String w3) {
    if (d3.equals("Feather")) {
        if (i3 > 1000 || r3.equals("n/a")) {
            return "";
        } else if (w3.equals("F")) {
            return "F";
        } else if (i3 <= 1000 && Integer.parseInt(r3) > 8) {
            return "F";
        } else {
            return "P";
        }
    } else {
        return "";
    }
}