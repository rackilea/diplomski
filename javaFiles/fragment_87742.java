public class Node {
    private String id;
    private String blockId;
    //setter-getters.
}

public class Connect {
    private String id;
    private String typeId;
    //setter-getters.
}

import java.util.List;

public class Payload {
    private List<Node> nodes;
    private List<Connect> connects;
    private String name;
    //setter-getters
}