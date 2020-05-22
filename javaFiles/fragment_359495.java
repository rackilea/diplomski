public class ImageFactory extends AbstractVertexFactory<ImageVertex> {

    @Override
    public ImageVertex createVertex(int id) {
        // TODO Auto-generated method stub
        return new ImageVertex(id);
    }
}