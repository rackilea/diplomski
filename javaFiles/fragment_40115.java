public static void main(String[] args){
        String text = "Associatepm: 4654-8199-9146";
        Pattern p = Pattern.compile("[0-9]{4}-?[0-9]{4}-?[0-9]{4}");
        Matcher m = p.matcher(text);
        boolean b = m.find();
        if(b == true){
            text = text.replaceAll("\\D+","");
        }
        System.out.println(text);

    }