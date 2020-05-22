public final class PartyAttendee
{
  ... person details ...
  Date arrive;

  int hashcode()
  {
    ... use Apache HashCodeBuilder ... 
  }

  boolean equals(Object other)
  {
    ... implementation left to student.  Use Apache EqualsBuilder ...
  }
}

Set<PartyAttendee> currentPartyAttendees;