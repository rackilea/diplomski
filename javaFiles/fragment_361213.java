try {
        File file = new File("D:\\file_to_read.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        HashMap<String, String> map = new HashMap<String, String>();
        String arry[] = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        while ((line = bufferedReader.readLine()) != null) {

            if ("".equals(line)) {
                list.add(map);
                map = new HashMap<String, String>();

                System.out.println("blank");
            } else {
                arry = line.split("=");
                map.put(arry[0].trim(), arry[1].trim());
            }

        }

        String picture = list.get(0).get("picture");
        String otherLetters = list.get(0).get("otherLetters");


        fileReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}