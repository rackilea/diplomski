map.get(key) match {
  case Some(MyInt(i))    => // logic for ints
  case Some(MyDouble(d)) => // logic for doubles
  case Some(MyString(s)) => // logic for strings
  case Some(MyNil)       => // logic for nulls
  case None              => // logic for "key not found"
}