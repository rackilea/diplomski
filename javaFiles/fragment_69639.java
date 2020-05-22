Person adam = new Person("Adam");
Person michael = new Person("Michael");
Person kerstin = new Person("Kerstin");
Person thomas = new Person("Thomas");
Person theresa = new Person("Theresa");

Person[] adamsFriends = { michael, kerstin };
adam.setFriendChain(adamsFriends);

Person[] michaelsFriends = { adam, kerstin };
michael.setFriendChain(michaelsFriends);

Person[] kerstinsFriends = { thomas, adam, michael };
kerstin.setFriendChain(kerstinsFriends);

Person[] thomasFriends = { kerstin, theresa };
thomas.setFriendChain(thomasFriends);

Person[] theresasFriends = { thomas };
theresa.setFriendChain(theresasFriends);