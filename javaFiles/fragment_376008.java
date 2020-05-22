path.push(end);                 // push node (n - 1)
String temp = edges.get(end);   // temp = node (n - 2)
while(!temp.equals(start)){
    path.push(edges.get(temp)); // push node (n - 3) down to and including node 0
    temp = path.peek();         // temp = node (n - 3) down to and including node 0
}
path.push(start);               // push node 0