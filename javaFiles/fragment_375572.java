@Test
    public void testN() throws Exception {
        List<String> l = HashCUtil.generateN(3);
        for(int i = 0; i < l.size(); ++i){
            System.out.println(l.get(i) + "---" + l.get(i).hashCode());
        }
    }
AaAaAa---1952508096
AaAaBB---1952508096
AaBBAa---1952508096
AaBBBB---1952508096
BBAaAa---1952508096
BBAaBB---1952508096
BBBBAa---1952508096
BBBBBB---1952508096