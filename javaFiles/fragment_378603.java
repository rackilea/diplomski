class SpecialNode extends Node {
    void foo() {
        // euwww
        SpecialNode nextNode = (SpecialNode) this.next;
    }
}