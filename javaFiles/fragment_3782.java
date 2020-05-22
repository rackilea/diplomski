public static Horse newSwimmingHorse() {

  final Object methodScopeProperty = ...;

  class SwimmingHorse extends Horse implements KnowsHowToSwim {
    double speed;
    double getHowFast(){
      methodScopeProperty.doSomething(); //do you need this access?
      return speed;
    }
  }

  return new SwimmingHorse();

}