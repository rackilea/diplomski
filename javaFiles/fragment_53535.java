public void resize(int width, int height)
{
        cam.viewportHeight = height; //set the viewport
        cam.viewportWidth = width; 
        if (Config.VIRTUAL_VIEW_WIDTH / cam.viewportWidth < Config.VIRTUAL_VIEW_HEIGHT
                / cam.viewportHeight) {
//sett the right zoom direct
            cam.zoom = Config.VIRTUAL_VIEW_HEIGHT / cam.viewportHeight;
        } else {
//sett the right zoom direct
            cam.zoom = Config.VIRTUAL_VIEW_WIDTH / cam.viewportWidth;
        }
        cam.update(); 
}