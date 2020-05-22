class Renderer {
     public void render(List<GraphicObject> objects) {
         for (GraphicObject object : objects) {
             object.draw();
         }
     }
}