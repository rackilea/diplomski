Class gifStateClass = Class.forName("com.bumptech.glide.load.resource.gif.GifDrawable$GifState");
 Field frameLoaderField = gifStateClass.getDeclaredField("frameLoader");
 frameLoaderField.setAccessible(true);
 Object frameLoader = frameLoaderField.get(gifDrawable.getConstantState());

 Class frameLoaderClass = Class.forName("com.bumptech.glide.load.resource.gif.GifFrameLoader");
 Field gifDecoderField = frameLoaderClass.getDeclaredField("gifDecoder");
 gifDecoderField.setAccessible(true);
 GifDecoder gifDecoder = (GifDecoder) gifDecoderField.get(frameLoader);

 int duration = 0;
 for (int i = 0; i < gifDrawable.getFrameCount(); i++) {
     duration += gifDecoder.getDelay(i);
 }