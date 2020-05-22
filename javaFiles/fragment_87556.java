liczby.removeIf(any -> any.equals(3));
//-------------------------------------------------
liczby.removeIf(new Integer(3)::equals);
//-------------------------------------------------
Integer toRemove = 3;
liczby.removeIf(toRemove::equals);