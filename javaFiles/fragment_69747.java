Scanner num = new Scanner(System.in);
double pi = 0.0;
do {
    System.out.println("What is pi?");
    pi = num.nextDouble();
}
while( pi != 3.14);

System.out.println("Yup pi = 3.14");