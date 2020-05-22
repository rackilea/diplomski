class MessageTreeBuilder extends NodeBuilder {
    Object createNode(Object name, Object value) {
        def payload = name == 'message' ? new Message(value) : value

        [currentNode, name, payload] as Node
    }
}