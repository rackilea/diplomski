interface DoesSomething {
    // An object implementing this interface does something.
    public void doSomething();
}

// Class that does something.
class FirstClass implements DoesSomething {

    @Override
    public void doSomething() {
        // What FirstClass does.
    }

}

// Another class that does something.
class SecondClass implements DoesSomething {

    @Override
    public void doSomething() {
        // What SecondClass does.
    }

}


// How I know what to do. Map the string to a DoesSomethng.
Map<String, DoesSomething> whatToDo = new HashMap<>();
{
    // Populate my map.
    whatToDo.put("1", new FirstClass());
    whatToDo.put("2", new SecondClass());
}

public void doSomethingDependingOnSomething(String something) {
    // Look up the string in the map.
    DoesSomething toDo = whatToDo.get(something);
    // Was it in there?
    if (toDo != null) {
        // Yes! Make it do it's thing.
        toDo.doSomething();
    }
}