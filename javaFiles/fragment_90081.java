public class Node {
    // Again, this is managed by Hibernate.
    // There is no matching column in the database.
    @OneToMany(cascade = CascadeType.ALL) // mappedBy is only necessary when there are two fields with the type "Node"
    private List<Node> children;

    // This field exists in the database.
    // For the OO model, it's not really necessary and in fact
    // some XML implementations omit it to save memory.
    // Of course, that limits your options to navigate the tree.
    @ManyToOne
    private Node parent;
}