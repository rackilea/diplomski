public static void main(String[] args) throws Exception {
        File f = new File("src/test/file.txt");
        BufferedReader read = new BufferedReader(new FileReader(f));
        String temp;
        String result = "";
        while ((temp = read.readLine()) != null) {
            result += temp;
        }
        result = result.replaceAll("\\{", " ");
        result = result.replaceAll("\\}", " ");
        result = result.replaceAll("network=", " ");
        result = result.trim();

        String[] list = result.split("[ ]+(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        for (String s : list) {
            s = s.trim();
            Pattern p = Pattern.compile("(.*)=(.*)");
            Matcher m = p.matcher(s);
            while (m.find()) {
                System.out.println("Key: " + m.group(1));
                System.out.println("Value: " + m.group(2));
            }
        }

    }