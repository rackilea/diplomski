import java.util.ArrayList;
 import java.util.List;


public class Node {

String id;
String name;
String data;
List<Node> children;
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getData() {
    return data;
}
public void setData(String data) {
    this.data = data;
}
public List<Node> getChildren() {
    return children;
}
public void setChildren(List<Node> children) {
    this.children = children;
}

public String toJson()
{
    return JsonConvertor.toJson(this);
}

public Node(String id, String name, String data) {
    super();
    this.id = id;
    this.name = name;
    this.data = data;
}
public Node(String id, String name, String data, List<Node> children) {
    super();
    this.id = id;
    this.name = name;
    this.data = data;
    this.children = children;
}
 public static void main(String[] args) {

    Node n5=new Node("1","YEAR-01","");
    List<Node> list3=new ArrayList<Node>();
    list3.add(n5);


    Node n3=new Node("1","COMPUTER SCIENCE","",list3);
    Node n4=new Node("1","EXTC","",list3);
    List<Node> list=new ArrayList<Node>();
    List<Node> list2=new ArrayList<Node>();

    list2.add(n3);

    list2.add(n4);
    Node n2=new Node("1","STREAM-ENGG","",list2);

    list.add(n2);


    Node n1=new Node("1","EDUCATION","",list);
    System.out.println(n1.toJson());

}

}