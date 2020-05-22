Pattern pat3 = Pattern.compile("[a-z]+[a-z\\d]+{3,}\\@[a-z]+\\.[a-z]+");

// Your Code

while(mat3.find()){
    System.out.println("Position: " + mat3.start() + " ---  Match: " + mat3.group());
}