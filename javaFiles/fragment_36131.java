import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.ximpleware.AutoPilot;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

public class RecursiveVtdTest {
  public static class Group {
    // attribute "name"
    private String name;

    // elements "element"
    private List<Element> elements = new LinkedList<Element>();

    // elements "group"
    private List<Group> groups = new LinkedList<Group>();

    public String toString(int ind) {
      String str = "";
      for (int i=0; i<ind; i++) {
        str += " ";
      }
      str += String.format("name=%s, elements=%s, groups=\n", this.name, this.elements.toString());
      for (Group g: this.groups) {
        str += g.toString(ind + 2);
      }
      return str;
    }

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public List<Element> getElements() {
      return this.elements;
    }

    public List<Group> getGroups() {
      return this.groups;
    }
  }

  public static class Element {
    // text of XML element
    private String value;

    @Override
    public String toString() {
      return String.format("v=%s", this.value);
    }

    public Element(String value) {
      this.value = value;
    }

    public String getValue() {
      return this.value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  @Test
  public void loadRecursiveXML() throws Exception {
    String xml = "" +
        "<group name=\"A\">\n" + 
        "  <element>1</element>\n" + 
        "  <groups>\n" + 
        "    <group name=\"B\">\n" + 
        "      <element>2</element>\n" + 
        "      <element>3</element>\n" + 
        "      <groups></groups>\n" + 
        "    </group>\n" + 
        "    <group name=\"C\">\n" + 
        "      <element>4</element>\n" + 
        "      <groups></groups>\n" + 
        "    </group>\n" + 
        "  </groups>\n" + 
        "</group>\n";

    byte[] doc = xml.getBytes();

    VTDGen vtd = new VTDGen();
    vtd.setDoc(doc);

    vtd.parse(true);

    VTDNav nav = vtd.getNav();
    AutoPilot ap = new AutoPilot(nav);
    ap.selectElementNS("*", "*");

    Group currentGroup = null;
    Deque<List<Group>> groupLists = new LinkedList<List<Group>>();
    groupLists.push(new LinkedList<Group>());

    int currentDepth = -1;

    while (ap.iterate()) {
      int n = nav.getCurrentIndex();
      int d = nav.getCurrentDepth();
      String elName = nav.toString(n);
      if (elName.equals("group")) {
        currentGroup = new Group();
        // group name
        int type = nav.getTokenType(n + 1);
        if (type == VTDNav.TOKEN_ATTR_NAME && nav.toString(n + 1).equals("name")) {
          String name = nav.toString(n + 2);
          currentGroup.setName(name);
        }
        // remove group lists if navigator went up in XML
        if (currentDepth >= d) {
          for (int i = 0; i <= currentDepth - d; i+=2) {
            groupLists.pop();
          }
        }
        // add to current group list
        groupLists.peek().add(currentGroup);
        // change current group list
        groupLists.push(currentGroup.getGroups());
        currentDepth = d;
      } else if (elName.equals("element")) {
        currentGroup.getElements().add(new Element(nav.toString(n + 1)));
      }
    }

    System.out.println(groupLists.getLast().get(0).toString(0));
  }
}