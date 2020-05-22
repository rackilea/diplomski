public java.util.List<ListNode> showRev(java.util.List<ListNode> nodes) {
    if (this.nextNode == null) {
        Collections.reverse(nodes);

        System.out.println(nodes.stream().collect(Collectors.joining(" ")));

        return nodes;
    }

    nodes.add(lastNode.show());

    return showRev(nodes);
}