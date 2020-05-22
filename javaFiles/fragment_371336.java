FileInputStream fin;
try {
   File f = new File("C:/Users/NetBeansProjects/QuestionOne/input.txt");
   fin = new FileInputStream(f);
} finally {
   //you cannot be sure fin is initialized
   fin.close(); //compiler error
}