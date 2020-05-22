public class BarcodeValidator implements ConstraintValidator<Barcode, String> {

  private List<Integer> lengths;

  @Override
  public void initialize(Barcode barcode) {
    lengths = new ArrayList<>(barcode.lengths().length);
    for (int l : barcode.lengths()) lengths.add(l);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    context.unwrap(HibernateConstraintValidatorContext.class).addExpressionVariable("joinedLengths", String.join(" / ", lengths));
    return value != null && lengths.contains(value.length());
  }
}