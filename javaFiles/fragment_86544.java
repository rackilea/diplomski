public class MyView implements PolymerTemplate<Model> {

    @Id("upload") // com.vaadin.flow.component.polymertemplate
    private Upload upload; // NO INSTANTIATION!
    private private final MemoryBuffer buffer = new MemoryBuffer();

    public MyView (){
        upload.setReceiver(buffer);
        upload.addSucceededListener(event -> {
            System.out.println(event.getFileName());
            System.out.println(buffer.getInputStream());
        });
    }
}