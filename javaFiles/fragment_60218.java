String name="", youngName;
int age=Integer.MAX_VALUE, youngAge;

while (!name.equals("FINISH")) {
    name = JOptionPane.showInputDialog("Enter a name: ");
    age = Integer.parseInt(JOptionPane.showInputDialog("Enter " + name + "'s age: "));

    if(age <= youngAge && !name.equals("FINISH")) {
        youngAge = age;
        youngName = name;
    }
}

JOptionPane.showMessageDialog("The youngest age is: " + youngAge + ".  It's " + youngName + ".");