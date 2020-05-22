String gender;
do
{
  System.out.print("Enter Gender ('male' or 'female'): ");
  gender = one.nextLine().toLowercase();
} while(!gender.equals("male") && !gender.equals("female"))