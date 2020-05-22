public static Node addPolynomials(Node n1, Node n2) {
    Node x = n1;
    Node y = n2;

    for(x = n1; x != null; x = x.next){
        for(y = n2; y != null; y = y.next){
            if(x.getData2() == y.getData2()){
                x.addData1(y);
                System.out.println("added " + (x.data1 - y.data1) + " and " + y.data1);
            }

        }
    }

    return x;
}