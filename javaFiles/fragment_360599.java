System.out.println("please enter time : ");
String a2 = input.nextLine();
for (int s = 0; s < timeArray.size(); s++) {
if (!timeArray.get(s).equals(a2))
System.out.println("invalid time , please enter another time : ");
a2 = input.nextLine();
}