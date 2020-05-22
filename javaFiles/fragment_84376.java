Imports: { import static gate.Utils.*; }
Phase: PageSpans
Input: PageNumber
Options: control = once

Rule: PageSpan
({PageNumber})
-->
{
  try {
    List<Annotation> numbers = inDocumentOrder(inputAS.get("PageNumber"));
    for(int i = 0; i < numbers.size(); i++) {
      outputAS.add(start(numbers.get(i)), // from start of this PageNumber, to...
                   (i+1 < numbers.size()
                     ? start(numbers.get(i+1)) // start of the next number, or...
                     : end(doc) // ...if no more PageNumbers then end of document
                   ),
                   "Page",
                   // store the text under the PageNumber as a feature of Page
                   featureMap("id", stringFor(doc, numbers.get(i))));
    }
  } catch(InvalidOffsetException e) {
    throw new JapeException("Invalid offset from existing annotation", e);
  }
}