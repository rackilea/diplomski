List<Person> personlst = new ArrayList<Person>();
            while (phones.moveToNext())
            {
                personlst.add(new Person("Hi"   , " programmer"));
                personlst.add(new Person("Hello", " world"));
            }
            Object[]arryPer = personlst.toArray();
            Person[]people = new Person[arryPer.length];

        for (int j = 0; j < arryPer.length; j++) {
            people[j] = (Person) arryPer[j];
        }