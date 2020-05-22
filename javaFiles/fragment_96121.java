boolean more = keys.hasNext();
while (more) {
   writer.append(keys.next().getCount());
   more = keys.hasNext();
   if(more) {
      writer.append(',');
   }
}