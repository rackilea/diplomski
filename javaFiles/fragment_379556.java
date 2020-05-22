public class GreyedOutImageBtn extends ImageButton {
    private boolean isGreyedOut; // A flag that determines whther or not this should be greyed out
    public GreyedOutImageBtn(ImageButtonStyle style) {
        super(style);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // When clicked, toggle the grey effect
                Gdx.app.log("ClickListener", "Click");
                setIsGreyedOut(!getIsGreyedOut());
            }
        });
        isGreyedOut = false;
    }

    public boolean getIsGreyedOut() {
        return isGreyedOut;
    }

    public void setIsGreyedOut(boolean isGreyedOut) {
        this.isGreyedOut = isGreyedOut;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (getIsGreyedOut()) {
            batch.end();
            batch.setShader(shader); // Set our grey-out shader to the batch
            batch.begin();
            super.draw(batch, parentAlpha); // Draw the image with the greyed out affect
            batch.setShader(null); // Remove shader from batch so that other images using the same batch won't be affected
        }
        else {
            // If not required to be grey-out, do normal drawing
            super.draw(batch, parentAlpha);
        }
    }
}