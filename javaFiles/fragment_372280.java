// Not clear why this is an instance variable - and please make fields private :)
List<Square> test = new ArrayList<Square>();

public void main() {
    test.add(new Square(10));

    Iterator<Square> i = test.iterator();
    while(i.hasNext()) {
        Square temp = i.next();
        // Use square here
    }
}