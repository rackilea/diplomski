@Override
public boolean equals(Object that)
{
    if (this == that)
      return true;
    if (that instanceof Ie) {
      Object ThisValue = this.value;
      Object ThatValue = ((Ie<?>) that).value;
      return ThisValue.equals(ThatValue);
    } else 
      return false;
}