private static HashMap<String, String[]> subjects;

public TestApp() {
}

public static void main(String[] args){
    subjects = new HashMap<String, String[]>();
    subjects.put("calculus",new String[] {"math","logic"});
    subjects.put("chemisty",new String[] {"ions","electrons"});
    subjects.put("biology",new String[] {"life","bacteria"});
    for(String s:subjects.get("biology")){
        System.out.println(s);
    }
}