if(toStartFrom.prev != null)
{
   toStartFrom.prev.next = b;
}
if(toStartFrom.next != b) // Equivalent to NextToEachOther
{
   toStartFrom.next.prev = b;
}
if(b.next != null)
{
   b.next.prev = toStartFrom;
}
if(b.prev != toStartFrom)  // Equivalent to NextToEachOther
{
   b.prev.next = toStartFrom
}