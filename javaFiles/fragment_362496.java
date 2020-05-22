strict = org.joda.time.format.DateTimeFormat.forPattern("MM/dd/yyyy")
try {
    strict.parseDateTime('40/40/4353')
    assert false
} catch (org.joda.time.IllegalFieldValueException e) {
    assert 'Cannot parse "40/40/4353": Value 40 for monthOfYear must be in the range [1,12]' == e.message
}