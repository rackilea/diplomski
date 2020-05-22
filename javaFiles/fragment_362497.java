try {
    df = new java.text.SimpleDateFormat('MM/dd/yyyy')
    df.setLenient(false)
    df.parse('40/40/4353')
    assert false
} catch (java.text.ParseException e) {
    assert e.message =~ 'Unparseable'
}