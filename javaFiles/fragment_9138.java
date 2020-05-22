private static class VertexLabelTransformer implements Transformer<Integer,String>{
    private final PickedInfo<Integer> pi;

    public VertexLabelTransformer( PickedInfo<Integer> pi ){
        this.pi = pi;
    }

    @Override
    public String transform(Integer t) {
        if (pi.isPicked(t))
            return t.toString();
        else
          return "";
    }
}