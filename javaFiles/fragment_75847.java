List<Integer> test = new ArrayList<Integer>();  
    test.add(3);
    test.add(2);
    test.add(1);
    test.add(2);
//  test.add(4);
//  test.add(6);
//  test.add(7);
//  test.add(8);
    test.add(1);
    test.add(2);        
    test.add(1000);
    test.add(97777);
    test.add(487);
    test.add(8274);
    test.add(972837);
    List<Integer> output = new ArrayList<Integer>();    
    List<Integer> temp = new ArrayList<Integer>();  
    for(int i = 0; i < test.size(); i++) {
        int current = test.get(i);          
        int next = Integer.MIN_VALUE;
        if(i + 1 < test.size()) next = test.get(i + 1);
        if(current > next) {
            if(output.size() <= temp.size()) {
                temp.add(current);
                output = new ArrayList<Integer>(temp);
            }
            temp.clear();
        } else {
            temp.add(current);      
        }
    }       
    output.forEach(i -> System.out.print(i + ", "));