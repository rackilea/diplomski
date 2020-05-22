public static class FileTarget<T extends Bitmap> extends TargetAdapter<Bitmap> {
    // ...

    @Override
    public void getSize(SizeReadyCallback cb) {
        cb.onSizeReady(width, height);
    }

    @Nullable
    @Override
    public Request getRequest() {
        return null;
    }

    @Override
    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
        try {
            FileOutputStream out = new FileOutputStream(fileName);
            resource.compress(format, quality, out);
            out.flush();
            out.close();
            onFileSaved();
        } catch (IOException e) {
            e.printStackTrace();
            onSaveException(e);
        }
    }

    // ...
}