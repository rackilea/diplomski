public abstract class Call {
String name;

public Call(String name){
    this.name=name;
}

public String evaluate(){
    return this.name;
}

 }

public abstract class Instruction {
String name;

public Instruction(String name){
    this.name=name;
}

public String evaluate(){
    return this.name;
}   
}