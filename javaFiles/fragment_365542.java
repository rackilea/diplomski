public static void main(String[] args) {
        String example = "United Kingdom (UK), United States Of America (USA), India (IND)";
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(example);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }