String ans;
List<Tutor> myTutor = new ArrayList<Tutor>(); //You have to specify Tutor in your Template-Class
for (int i = 0; i<myTutor.size; i++)
    {
    ans = JOptionPane.showInputDialog(null,"Enter Tutor's Last Name, First Name, and Highest Level of Degree:");
    //Here you have a lot to do because you get one inputstring with all 3 Elements
    //You have to split the input or get 3 seperate inputs
    // We assume you have your correct input here right now with Strings fname, lname, level
    Tutor t = new Tutor(lname,fname,level);
    myTutor.add(t);
    }
}