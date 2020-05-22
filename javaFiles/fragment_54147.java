@Produces
@Dependent //choose desired scope, or none and it will be dependeny
// you can also add qualifiers, optional
public Random produceRandom() {
  return new Random();
}