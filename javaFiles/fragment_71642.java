@Override
public KPData process(InputDetail inputData) throws MyException {
  try {
    business logic here
  }
  catch(Exception e) {
    throw new MyException("Some issue");
  }
}