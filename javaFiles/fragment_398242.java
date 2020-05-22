URL imgUrl = getClass().getResource("tileset_ground.png");
tileset_image = getImage(imgUrl);

num_images = HOWEVER MANY IMAGES ARE IN THE TILESET

for (int i = 0; i < num_images; i++) {

    ImageFilter imgF = new CropImageFilter(0, 26 * i, 26, 26);
    ImageProducer imgP = new FilteredImageSource(tileset_image.getSource(), imgF);
    Screen.tileset_ground[i] = createImage(imgP);  

}