public void numberOfStudentsWhoSelectedEachActivity(){
        HashMap<String, Integer> map = new HashMap<>();
        for(Object s : studentList){
            Student student = (Student) s;
            String act = student.activity;
            if(map.get(act) == null){
                map.put(act, 1);
            }
            else{
                map.put(act, map.get(act)+1);
            }
        }
        System.out.println(map);
    }