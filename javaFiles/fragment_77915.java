class PackedScrolledComposite extends ScrolledComposite
{
    Point scrollBarSize;  // Size of OS-specific scrollbar

    public PackedScrolledComposite(Composite parent, int style)
    {
        super(parent, style);

        Composite composite = new Composite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        composite.setSize(1, 1);
        scrollBarSize = composite.computeSize(0, 0);
        composite.dispose();
    }

    public Point computeSize(int wHint, int hHint, boolean changed)
    {
        Point point = super.computeSize(wHint, hHint, changed);
        point.x += ((getStyle() & SWT.V_SCROLL) != 0) ? -scrollBarSize.x : 0;
        point.y += ((getStyle() & SWT.H_SCROLL) != 0) ? -scrollBarSize.y : 0;

        return point;
    }
}