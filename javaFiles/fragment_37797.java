String name = "stackover";
String lName = " flow";
String nick = " stackoverflow";
String email = "stackoverflow@email.com";
int phone = 123123123;

//for (int i = 0; i < 10; i++) {
long initialTime1 = System.currentTimeMillis();
String response = String.format(" - Contact {name=%s, lastName=%s, nickName=%s, email=%s, phone=%d}",
                                name, lName, nick, email, phone);
long finalTime1 = System.currentTimeMillis();
long totalTime1 = finalTime1 - initialTime1;
System.out.println(totalTime1 + response);

long initialTime2 = System.currentTimeMillis();
final StringBuilder sb = new StringBuilder(" - Contact {");
sb.append("name=").append(name)
  .append(", lastName=").append(lName)
  .append(", nickName=").append(nick)
  .append(", email=").append(email)
  .append(", phone=").append(phone)
  .append('}');
String response2 = sb.toString();
long finalTime2 = System.currentTimeMillis();
long totalTime2 = finalTime2 - initialTime2;
System.out.println(totalTime2 + response2);
//}