RootNode Start() : 
{
  Section1Node s1Node = null;
  Section2Node s2Node = null;

  List s3Nodes = new LinkedList();
  Section3Node s3Node = null;
} 
{
  (
    ( s1Node = Section1() )?
    ( s2Node = Section2() )?
    ( s3Node = Section3() {s3Nodes.add(s3Node); } )*
  )  {

    return new RootNode(s1Node, s2Node, s3Nodes);
  }
}