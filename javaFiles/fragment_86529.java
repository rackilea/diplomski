import lombok.Data;

@Data // Lombok magic
public class Module {
    private String name;
    // ...

    public Module(ie.gmit.proto.Module moduleProto){
        this.name = moduleProto.getName();
        // ...
    }
}