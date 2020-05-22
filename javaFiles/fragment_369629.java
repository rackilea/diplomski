81      else if (targetClass.equals(Integer.class)) {
82          long value = number.longValue();
83          if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
84              raiseOverflowException(number, targetClass);
85          }
86          return (T) new Integer(number.intValue());
87      }