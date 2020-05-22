varbind[] varbinds = trapPdu.getResponseVarbinds();

for (varbind var: varbinds) {
    System.out.println("OID: ", var.getOid().toString());
    System.out.println("Value: ", var.getValue().toString());
}