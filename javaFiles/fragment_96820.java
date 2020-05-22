try (Transaction tx = db.beginTx()) {
    Node node = db.createNode();
    node.setProperty("__version", "1.0.0");
    node.setProperty("__author", "Dmitry");
    tx.success();
}