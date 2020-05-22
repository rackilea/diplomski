public final class PShapeWrapper implements PWrapper {

    private final PShape ps;

    public PShapeWrapper (PShape ps){
        this.ps = ps;
    }

    @Override
    public void beginShape(){
        ps.beginShape();
    }

    @Override
    public void vertex(){
        ps.vertex();
    }
}