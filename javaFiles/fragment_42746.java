getPerson2 foreach (_.display)
for (person <- getPerson2) person.display
getPerson2 match {
  case Some(person) => person.display
  case _ =>
}
getPerson2.getOrElse(Person("Unknown", 0)).display