import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class ImgCanvas
{
    private Canvas canvas;
    private Image img; 
    private int lastImgHash = 0;

    public ImgCanvas(Composite parent)
    {
        canvas = new Canvas(parent, SWT.BORDER);
        initCanvas();
    }

    public ImgCanvas(Composite parent, Image img)
    {
        canvas = new Canvas(parent, SWT.NONE);
       // canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
     //   canvas.layout();
        setImage(img);
        initCanvas();
    }

    public void setCanvas(Canvas canvas)
    {
        this.canvas = canvas;
        this.initCanvas();
    }

    public void setImage(Image img)
    {
        if (this.img != null)
            this.img.dispose();
        this.img = img;

       // canvas.pack();
      // canvas.getParent().getParent().layout();
      //  canvas.getParent().getParent().getParent().layout();
        canvas.getParent().setSize(img.getBounds().width,canvas.getParent().getSize().y);
        canvas.setSize(img.getBounds().width, img.getBounds().height);



        System.out.println("Set image: " + img.getBounds() + ", " + img.toString());
        redraw();
    }

    public void redraw()
    {
        canvas.redraw();
    }

    protected void initCanvas()
    {
        System.out.println("Canvas started");
        canvas.addPaintListener( getPaintListener() );
        canvas.addDisposeListener( getDisposeListener() );
    }

    protected PaintListener getPaintListener()
    {
        return new PaintListener()
        {
            public void paintControl(PaintEvent e)
            {
                System.out.println("Painting");
                if (img != null )
                {
                    System.out.println("Img:" + img.getBounds() );
                    e.gc.drawImage(img, 0, 0);
                 //   canvas.setSize(img.getBounds().width, img.getBounds().width);
                 //   canvas.pack();
                }
                else
                    System.out.println("Img is null: " + img);
            }
        };
    }

    protected DisposeListener getDisposeListener()
    {
        return new DisposeListener()
        {
            @Override
            public void widgetDisposed(DisposeEvent e)
            {
                System.out.println("Disposing");
                if (img != null)
                    img.dispose();
            }
        };
    }
}