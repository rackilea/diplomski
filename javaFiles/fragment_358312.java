public String encryptString(String input){
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray())
            sb.append(encrypt(c));
        return sb.toString();
}