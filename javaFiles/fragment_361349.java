tr = 'GROOVY'

class Tmp {
    static Binding context
    static map = {
        def cols = [header: { "JAVA" }, trailer: { context.tr }]
    }
}

Tmp.context = binding
Tmp.map().collect { k, v -> println v() }