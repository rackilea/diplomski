final Set<PhoneNumber> contactNumbers = new TreeSet<PhoneNumber>();
contactNumbers.add(new PhoneNumber(Phone.TYPE_HOME, "1"));
contactNumbers.add(new PhoneNumber(Phone.TYPE_MOBILE, "6"));
contactNumbers.add(new PhoneNumber(Phone.TYPE_OTHER, "3"));
contactNumbers.add(new PhoneNumber(Phone.TYPE_HOME, "2"));
contactNumbers.add(new PhoneNumber(Phone.TYPE_WORK, "4"));
contactNumbers.add(new PhoneNumber(Phone.TYPE_MOBILE, "5"));

// Prints [TYPE_MOBILE:5, TYPE_MOBILE:6, TYPE_HOME:1, TYPE_HOME:2, TYPE_WORK:4, TYPE_OTHER:3]
System.out.println(Arrays.toString(contactNumbers.toArray()));