public static void main(String[] args) {
    LinkedList<person> phonedir = new LinkedList<person>(); 
    person one = new person("John", "Doe", "1234567890"); 
    phonedir.add(one); 
    person two = phonedir.get(0); 
    two.print(); 
}