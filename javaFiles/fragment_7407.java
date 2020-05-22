abstract class Parameter {
  abstract String getOtherName() 
  String getName() { return "test" }
}

def p1 = [name:{"p1Name"}, getOtherName:{""}] as Parameter