regex = "(?:(?:(\\d+)[ ]*(?:'|ft)){0,1}[ ]*(\\d*(?![/\\w])){0,1}(?:[ ,\\-]){0,1}((\\d*)\\/(\\d*)){0,1}(\\.\\d*){0,1}(?:\\x22| in))|(?:(\\d+)[ ]*(?:'|ft)[ ]*){1}";
subs = REFind(regex,input,1,"True");
if (subs.pos[1] eq 0) {
  found = "False";
} else {
  found = "True";
  feet = Mid(input,subs.pos[2],subs.len[2]);
  inches = Mid(input,subs.pos[3],subs.len[3]);
  fraction = Mid(input,subs.pos[4],subs.len[4]);
  fracNum = Mid(input,subs.pos[5],subs.len[5]);
  fracDem = Mid(input,subs.pos[6],subs.len[6]);
  decimal = Mid(input,subs.pos[7],subs.len[7]);
  if (feet is "") {
    // Use the _other_ feet
    feet = Mid(input,subs.pos[8],subs.len[8]);
  }
}