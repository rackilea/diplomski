private static final Map<Character, Integer> VALUES = new LinkedHashMap<>();

static{
    for(char c : "\n !\\,-.:;?".toCharArray()){
        VALUES.put(c, 0);
    }
    for(char c = 'a'; c < 'z'; c++){
        VALUES.put(c, 0);
    }
    for(char c = 'A'; c < 'Z'; c++){
        VALUES.put(c, 0);
    }
}

public static void main(String args[]){
    try{
        String file = args[0];
        FileReader scanner = new FileReader(file);
        int i;
        while ((i = scanner.read()) != -1) {
            Integer val = VALUES.get((char)i);
            if(val != null) VALUES.put((char)i, val + 1);
        }
        for(Map.Entry<Character, Integer> entry : VALUES.entrySet()){
            if(entry.getValue() > 0)
                System.out.println(entry.getKey() + " " + entry.getValue());
        }
    } catch(IOException ioe){
        ioe.printStackTrace();
    }
}