StringBuilder odds = new StringBuilder();
StringBuilder evens = new StringBuilder();
i = 50;
while(i<100) {
    if(i%2 == 1) {
        odds.append(i).append(",");
    }
    else {
        evens.append(i).append(",");
    }
    i++;
}
// remember that odds and evens now probably ends with a ','which you should remove
odds.removeCharAt(odds.size());
evens.removeCharAt(evens.size());
// or do something like the following:
//odds.append(" and nothing more!");
//evens.append(" and nothing more!");

System.out.println("Odd numbers are: ");
System.out.println(odds);
System.out.println("Even numbers are" ");
System.out.println(evens)