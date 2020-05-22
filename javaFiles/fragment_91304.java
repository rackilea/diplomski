public T evaluate(T left, T right) {
    if (left instanceof Integer && right instanceof Integer) {
      Integer result = ((Integer) left) + ((Integer) right);
      return (T) result;
    } else {
      return null;
    }
  }