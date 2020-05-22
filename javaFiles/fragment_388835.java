start with list containing just the trees root. call it CurrNodes.
maxWidth = 1;
start with empty list. call it NextNodes.
while(CurrNodes is not empty) {
   get all children of nodes in CurrNodes and add them to NextNodes
   if number of children is > maxWidth, # of children is the new maxWidth
   CurrNodes = NextNodes
   NextNodes = empty.
}