class CustomXMLGregorianCalendar extends XMLGregorianCalendar
{
    XMLGregorianCalendar calendar;

    CustomXMLGregorianCalendar(XMLGregorianCalendar calendar){
        this.calendar = calendar;
    }

    public String toXMLFormat() {
        String text = calendar.toXMLFormat();
        int pos = text.indexOf('Z');

        return pos < 0 ? text : text.substring(0,pos);
    }

    public void setTimezone(int offset){ calendar.setTimezone( offset ); }
    // ...
}