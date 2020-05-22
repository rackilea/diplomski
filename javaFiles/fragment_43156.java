/**
   * Contains the result of a single result in an aggregate query.
   */
  public class AggregateResult {

      private List<String> keys;
      private List<BigDecimal> values;

      @SuppressWarnings("unused")
      public AggregateResult(Object value1, Object value2) {
          this(new Object[] { value1, value2 });
      }

      @SuppressWarnings("unused")
      public AggregateResult(Object value1, Object value2, Object value3) {
          this(new Object[] { value1, value2, value3 });
      }

      @SuppressWarnings("unused")
      public AggregateResult(Object value1, Object value2, Object value3, Object value4) {
          this(new Object[] { value1, value2, value3, value4 });
      }

      @SuppressWarnings("unused")
      public AggregateResult(Object value1, Object value2, Object value3, Object value4, Object value5) {
          this(new Object[] { value1, value2, value3, value4, value5 });
      }

      public AggregateResult(Object... vals) {
          values = new ArrayList<>();
          while (values.size() < vals.length && vals[vals.length - values.size() - 1] instanceof Number) {
              Number number = (Number) vals[vals.length - values.size() - 1];
              values.add(number instanceof BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString()));
          }

          this.keys = Stream.of(ArrayUtils.subarray(vals, 0, vals.length - values.size())).map(Object::toString).collect(toList());
      }

      public List<String> getKeys() {
          return keys;
      }

      public List<BigDecimal> getValues() {
          return values;
      }

      /**
       * Returns the list of {@link AggregateResult}s for the raw result. The raw result is expected to
       * have been returned from a native JPA query.
       */
      public static List<AggregateResult> fromNativeResult(List<Object[]> raw) {
          return raw.stream().map(AggregateResult::new).collect(toList());
      }
  }