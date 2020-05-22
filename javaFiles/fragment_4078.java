BreakIterator i=BreakIterator.getSentenceInstance(Locale.US);
final String text = "Mr. smith and mrs.smith both born on April 2 1970. Barack born on November 4 1960.";
i.setText(text);
for(int s=i.first(), e=i.next(); e>=0; s=e, e=i.next())
{
  System.out.println("Sentence: from "+s+" to "+e+" \""+text.substring(s, e)+'"');
}