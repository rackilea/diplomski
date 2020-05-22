public static void pushdown(Stack s, int i){
    Integer marker = (Integer) s.size() - i;
    Object top = s.peek();
    Stack temp = new Stack();
    while(s.empty() != true){
        Object elem = s.pop();
        temp.push(elem);
    }
    while(temp.empty() != true){
        if(marker == s.size()){
            s.push(top);
        }
        Object elem = temp.pop();
        s.push(elem);
    }
}