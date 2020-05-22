public class MyLinkVisitor extends NodeVisitor {

    public MyLinkVisitor() { }

    public void visitTag(Tag tag) {
        if (tag.getTagName().equals("A")) {
            LinkTag link = (LinkTag) tag;
            link.setLink("http://newLink/"); //implement your logic here
        }
    }
}