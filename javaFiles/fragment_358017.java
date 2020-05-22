public String toString(){
    String str = "";
    if (head != null){
        Node current = head;
        do {
            str = str + current.getItem();
            current = current.next();
            if (current != head && current != null){
                str = str + ", ";
            }
        } while(current != head && current != null);
    }
    return str;
}