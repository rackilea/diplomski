Stack<Node> pending = new Stack<Node>();
pending.push(doc.getChildNodes().item(0));
while(!pending.empty())
{
   Node n = pending.pop();
   n.getChildNodes();
   ...
}