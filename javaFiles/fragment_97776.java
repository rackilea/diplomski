@Root(name = "p")
@Convert(value = P.PConvert.class)
public class P extends AtomicBlock{

public P() {
}

@ElementListUnion({

        @ElementList(entry = "gap", type = Gap.class, inline = true, required = false),
        @ElementList(entry = "br", type = Br.class, inline = true, required = false) })
private List<Object> inline;

public List<Object> getInline() {
    return inline;
}

public void setInline(List<Object> inline) {
    this.inline = inline;
}

@Override
public String toString() {
    return "TestP [inline=" + inline + "]";
}

static class PConvert implements Converter<P> {
    private final Serializer ser = new Persister();

    @Override
    public P read(InputNode node) throws Exception {
        P p = new P();

        p.inline = new ArrayList<Object>();
        p.inline.add(node.getValue());
        InputNode inputNode = node.getNext();

        while (inputNode != null) {
            String tag = inputNode.getName();
            if (tag.equalsIgnoreCase("gap")) {
                p.inline.add(ser.read(Gap.class, inputNode));
            } else if (tag.equalsIgnoreCase("br")) {
                p.inline.add(ser.read(Br.class, inputNode));
            }
            String value = node.getValue();
            p.inline.add(value);
            inputNode = node.getNext();
        }

        return p;
    }

    @Override
    public void write(OutputNode arg0, P arg1) throws Exception {
        // TODO Auto-generated method stub

    }
}

}