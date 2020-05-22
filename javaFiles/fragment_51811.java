public class MyRenderer implements Renderer {

private Vector<Square> scene;
private Vector<Square> bufferedSquaresToAddToScene

@Override
public void onDrawFrame(GL10 gl) {
    while(bufferedSquaresToAddToScene.size()>0){
        scene.add(bufferedSquaresToAddToScene.remove(0));
    }

    for(int i = 0;i<scene.size();i++){
        scene.get(i).draw(gl);
    }

}

public void addSquareToScene(Square square){
    bufferedSquaresToAddToScene.add(square);
}
}