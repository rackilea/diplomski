public static void main(String... args) {
    final File file = new File("inpath.png");
    final File out = new File("outpath.png");

    // This is just sugar for the point of illustration.
    // The purpose here is just to have access to a Context
    ImageJ imagej = new ImageJ();

    // Cache the context for future use.
    Context context = imagej.getContext();

    try {
        // Use the context to get the services we want to ensure they are all
        // properly initialized.
        // If this was a Command these could all be @Parameters to be populated
        // automatically.
        DatasetService datasetService = context.getService(DatasetService.class);
        CommandService commandService = context.getService(CommandService.class);
        DatasetIOService datasetIOService =
            context.getService(DatasetIOService.class);

        Dataset input = datasetIOService.open(file.getAbsolutePath());

        // Start the command
        Future<CommandModule> future =
            commandService.run(Binarize.class, true, "inputData", input);

        // Get the command output
        Dataset binarized = (Dataset) future.get().getOutput("outputMask");

        // The output type is a binary image which, at the moment, needs to be
        // explicitly converted to something that can be written out.
        // Adapted from:
        // http://fiji.sc/ImgLib2_Examples#Example_2c_-_Generic_copying_of_image_data
        Img inputImg = input.getImgPlus().getImg();
        Img outputImg = binarized.getImgPlus().getImg();
        Img typedImg =
            inputImg.factory().create(inputImg, inputImg.firstElement());
        scale(outputImg, typedImg);

        Dataset output = datasetService.create(typedImg);

        // Save the output dataset
        datasetIOService.save(output, out.getAbsolutePath());
    }
    catch (IOException exc) {
        exc.printStackTrace();
    }
    catch (InterruptedException exc) {
        exc.printStackTrace();
    }
    catch (ExecutionException exc) {
        exc.printStackTrace();
    }
    finally {
        // Dispose of the context to shut down
        context.dispose();
    }

}

public static <T extends IntegerType<T>> void scale(
    final RandomAccessible<BitType> source, final IterableInterval<T> target)
{
    // create a cursor that automatically localizes itself on every move
    Cursor<T> targetCursor = target.localizingCursor();
    RandomAccess<BitType> sourceRandomAccess = source.randomAccess();
    // iterate over the input cursor
    while (targetCursor.hasNext()) {\
        // move input cursor forward
        targetCursor.fwd();
        // set the output cursor to the position of the input cursor
        sourceRandomAccess.setPosition(targetCursor);
        // set the value of this pixel of the output image
        BitType b = sourceRandomAccess.get();
        if (b.get()) {
            targetCursor.get().setOne();
        }
        else {
            targetCursor.get().setZero();
        }
    }
}