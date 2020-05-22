public static void main(String[] args) throws Exception {
    // set up the execution environment
    final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

    DataSet<Element> oldDS = env.fromElements(new Element(1, "test"), new Element(2, "test"), new Element(3, "foobar"));
    DataSet<Element> newDS = env.fromElements(new Element(1, "test"), new Element(3, "foobar"), new Element(4, "test"));

    DataSet<Element> filtered = newDS.coGroup(oldDS).where("*").equalTo("*").with(new FilterCoGroup());

    filtered.print();
}

public static class FilterCoGroup implements CoGroupFunction<Element, Element, Element> {

    @Override
    public void coGroup(
            Iterable<Element> newElements,
            Iterable<Element> oldElements,
            Collector<Element> collector) throws Exception {

        List<Element> persistedElements = new ArrayList<Element>();

        for(Element element: oldElements) {
            persistedElements.add(element);
        }

        for(Element newElement: newElements) {
            boolean contained = false;

            for(Element oldElement: persistedElements) {
                if(newElement.equals(oldElement)){
                    contained = true;
                }
            }

            if(!contained) {
                collector.collect(newElement);
            }
        }
    }
}

public static class Element implements Key {
    private int id;
    private String name;

    public Element(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Element() {
        this(-1, "");
    }

    @Override
    public int hashCode() {
        return 31 + 7 * name.hashCode() + 11 * id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Element) {
            Element element = (Element) obj;

            return id == element.id && name.equals(element.name);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Element) {
            Element element = (Element) o;


            if(id == element.id) {
                return name.compareTo(element.name);
            } else {
                return id - element.id;
            }
        } else {
            throw new RuntimeException("Comparing incompatible types.");
        }
    }

    @Override
    public void write(DataOutputView dataOutputView) throws IOException {
        dataOutputView.writeInt(id);
        dataOutputView.writeUTF(name);
    }

    @Override
    public void read(DataInputView dataInputView) throws IOException {
        id = dataInputView.readInt();
        name = dataInputView.readUTF();
    }

    @Override
    public String toString() {
        return "(" + id + "; " + name + ")";
    }
}