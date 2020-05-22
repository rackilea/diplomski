interface ElementVisitor {
   visit(Element e);
   visit(SubElement se);
}

class ElementerPrinter implements ElementVisitor {
   visit(Element e) { System.out.println("e"); }
   visit(SubElement e) { System.out.println("sub"); }
}

class Element {
  // here's the trick, Element knows that this is Element
  // and childs have to implement it!
  // if the parent-most class is an interface it force you to implement!
  accept(ElementVisitor visitor) { visitor.visit(this); } 
}

class SubElement {
  // here's the trick, Element knows that this is SubElement
  accept(ElementVisitor visitor) { visitor.visit(this); }
}