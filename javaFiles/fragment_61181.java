/**
 * The StarRaring is a widget that displays a predefined number of images side
 * by side to realize a "star ranking". This star ranking has listeners to
 * listen to the user input and adjust the number of stars painted with full
 * alpha. The remaining stars are painted with a user defined alpha value
 * (default: 150)
 * 
 * @author Sebastian Raubach
 * 
 */

public class StarRating extends Composite
{
    private Image image;
    private int hoverSelected = 0;
    private int selected = 0;
    private int nrOfImages = 5;
    private int alpha = 150;
    private int width;
    private int height;
    private boolean vertical = false;

    /**
     * <p>
     * Creates a star rating widget with a default selection of 1 star
     * </p>
     * 
     * @param parent
     *            the hosting composite
     * @param style
     *            the widget style
     */
    public StarRating(Composite parent, int style)
    {
        super(parent, style);

        /* Add dispose listener for the image */
        addListener(SWT.Dispose, new Listener()
        {
            @Override
            public void handleEvent(Event arg0)
            {
                if(image != null)
                    image.dispose();
            }
        });

        /* Add custom paint listener that paints the stars */
        addListener(SWT.Paint, new Listener()
        {
            @Override
            public void handleEvent(Event e)
            {
                paintControl(e);
            }
        });

        /*
         * Keep track of the mouse movements and highlight possible new
         * selection
         */
        addListener(SWT.MouseMove, new Listener()
        {
            @Override
            public void handleEvent(Event arg0)
            {
                int x = arg0.x;
                int y = arg0.y;

                /* Determine direction */
                int step = (vertical ? height : width) + 1;
                int location = vertical ? y : x;

                /* Determine current index */
                int current = (location / step);

                /* Redraw if necessary */
                if (current != hoverSelected)
                {
                    hoverSelected = current;
                    redraw();
                }
            }
        });

        /* On mouse exit, reset selection */
        addListener(SWT.MouseExit, new Listener()
        {
            @Override
            public void handleEvent(Event arg0)
            {
                hoverSelected = selected;
                redraw();
            }
        });

        /* On mouse up, set new selection based on hover selection */
        addListener(SWT.MouseUp, new Listener()
        {
            @Override
            public void handleEvent(Event arg0)
            {
                selected = hoverSelected;
            }
        });
    }

    /**
     * <p>
     * Draws the images. Selected images are drawn with full alpha, unselected
     * images with the user defined alpha value
     * </p>
     * 
     * @param event
     *            The source event
     */
    private void paintControl(Event event)
    {
        GC gc = event.gc;

        if (image != null)
        {
            int stepX = vertical ? 0 : width + 1;
            int stepY = vertical ? height + 1 : 0;

            for (int i = 0; i < nrOfImages; i++)
            {
                if (i == hoverSelected + 1)
                    gc.setAlpha(alpha);

                gc.drawImage(image, 1 + stepX * i, 1 + stepY * i);
            }

            /* Reset alpha value */
            gc.setAlpha(255);
        }
    }

    /**
     * <p>
     * Returns the image used for the star painting
     * </p>
     * 
     * @return the image used for the star painting
     */
    public Image getImage()
    {
        return image;
    }

    /**
     * <p>
     * Set the image used for the star painting
     * </p>
     * 
     * @param image
     *            the image used for the star painting
     */
    public void setImage(Image image)
    {
        this.image = new Image(Display.getDefault(), image, SWT.IMAGE_COPY);
        width = image.getBounds().width;
        height = image.getBounds().height;
        redraw();
    }

    /**
     * <p>
     * Set the number of stars to be shown on the star rating
     * </p>
     * <p>
     * Minimum = 1, Maximum = unrestricted
     * </p>
     * 
     * @param nrOfStars
     *            the number of stars to be shown on the star rating
     */
    public void setNrOfStars(int nrOfStars)
    {
        if (nrOfStars < 1)
            throw new IllegalArgumentException("Invalid value for number of stars. Minimum: 1, Selection: " + nrOfStars);
        else
            nrOfImages = nrOfStars;
    }

    /**
     * <p>
     * Returns the number of stars to be shown on the star rating
     * </p>
     * 
     * @return the number of stars to be shown on the star rating
     */
    public int getNrOfStars()
    {
        return nrOfImages;
    }

    /**
     * <p>
     * Get the number of selected stars of the star rating
     * </p>
     * 
     * @return the number of selected stars of the star rating
     */
    public int getSelection()
    {
        return selected + 1;
    }

    /**
     * <p>
     * Set the number of selected stars of the star rating
     * </p>
     * <p>
     * Minimum = 1, Maximum = nr. of stars available
     * </p>
     * 
     * @param selection
     *            the number of selected stars of the star rating
     */
    public void setSelection(int selection)
    {
        if (selection < 0 || selection > nrOfImages)
            throw new IllegalArgumentException("Invalid value for star selection. Minimum: 0, Maximum: " + nrOfImages + ", Selection: " + selection);
        else
            selected = selection - 1;

        hoverSelected = selected;
    }

    /**
     * <p>
     * Set the alpha value used for painting the non-selected stars
     * </p>
     * <p>
     * Minimum = 0, Maximum = 255
     * </p>
     * 
     * @param alpha
     *            The alpha value used for painting the non-selected stars
     */
    public void setAlpha(int alpha)
    {

        if (alpha < 0 || alpha > 255)
            throw new IllegalArgumentException("Invalid alpha value. Minimum: 0, Maximum: 255, Selection: " + alpha);
        else
            this.alpha = alpha;
    }

    /**
     * <p>
     * Returns the alpha value used for painting the non-selected stars
     * </p>
     * 
     * @return the alpha value used for painting the non-selected stars
     */
    public int getAlpha()
    {
        return alpha;
    }

    /**
     * <p>
     * Set the orientation of the widget to vertical
     * </p>
     * 
     * @param vertical
     *            Set to true if the stars should be aligned in a vertical and
     *            to false if the stars should be aligned in a horizontal line
     */
    public void setVertical(boolean vertical)
    {
        this.vertical = vertical;
    }

    /**
     * <p>
     * Returns the orientation of the widget
     * </p>
     * 
     * @return true, if the widget is vertical, false if the widget is
     *         horizontal
     */
    public boolean getVertical()
    {
        return vertical;
    }

    @Override
    public Point computeSize(int wHint, int hHint, boolean changed)
    {
        int overallWidth = 0;
        int overallHeight = 0;

        /* Determine the preferred dimensions of the widget */
        if (image != null)
        {
            overallWidth = vertical ? width : width * nrOfImages + nrOfImages - 1;
            overallHeight = vertical ? height * nrOfImages + nrOfImages - 1 : height;
        }

        /* Consider hints */
        if (wHint != SWT.DEFAULT && wHint < overallWidth)
            overallWidth = wHint;

        if (hHint != SWT.DEFAULT && hHint < overallHeight)
            overallHeight = hHint;

        /* Return computed dimensions plus border */
        return new Point(overallWidth + 2, overallHeight + 2);
    }

    public static void main(String[] args)
    {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        StarRating star = new StarRating(shell, SWT.NONE);
        star.setImage(new Image(display, "star.png"));
        star.setVertical(true);
        star.setNrOfStars(10);
        star.setSelection(3);
        star.setAlpha(100);
        star.setVertical(false);

        shell.pack();
        shell.open();

        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}