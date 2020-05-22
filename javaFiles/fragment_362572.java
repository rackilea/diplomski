Random rand = new Random();
Person[] people = new Person[200];

for (int i = 0; i < people.length; i++) {
    Person p = new Person();
    people[i] = p;

    // Sex
    p.setSex(rand.nextBoolean() ? "Male" : "Female");
    // p.setSex(i % 2 == 0 ? "Male" : "Female");

    // Age (normal distribution with min 0, max 100, and mean 50
    int age = (int)(rand.nextGaussian() * 50);
    while (Math.abs(age) > 50)
        age = (int)(rand.nextGaussian() * 50);
    p.setAge(age + 50);

    // Religion
    int maxA = (int) (people.length * .1),
        maxB = (int) (people.length * .5) + maxA;
    if (i < maxA)
        p.setReligion("A");
    else if (i < maxB)
        p.setReligion("B");
    else
        p.setReligion("C");
}

// probably shuffle at the end so that religions aren't contiguous