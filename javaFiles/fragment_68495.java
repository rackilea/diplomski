@Bean(name = "john")
public Person john(){
    return new Person("John");
}

@Bean(name = "jack")
public Person jack(){
    return new Person("Jack");
}