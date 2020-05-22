import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.util.Random;

/**
 * A {@link java.awt.LayoutManager} which lays out randomly all the {@link java.awt.Component}s
 * of its parent, taking into consideration the parent's {@link java.awt.Insets}.
 * <p>
 * Use {@link #setRandomizeOnce(boolean)} method to determine if the lastly laid-out parent will
 * be only laid-out randomly once and not for each {@link #layoutContainer(java.awt.Container)}
 * subsequent call for the same parent, or the opposite.
 * </p>
 */
public class RandomLayout implements LayoutManager {
    /**
     * The {@link java.awt.Container} which was lastly laid-out.
     */
    private Container lastParent;

    /**
     * The {@link java.awt.Insets} of {@code lastParent} the last time it was laid-out.
     */
    private Insets lastInsets;

    /**
     * If {@code true} then this {@link java.awt.LayoutManager} keeps track of the
     * {@link java.awt.Container}s laid-out to make sure that {@code lastParent} is
     * only laid-out once. If the another {@link java.awt.Container} is laid-out, other
     * than {@code lastParent}, then its components are laid-out randomly and the
     * {@link java.awt.Container} becomes the {@code lastParent}.
     */
    private boolean randomizeOnce;

    /**
     * Normal constructor of {@code RandomLayout} with explicit value for {@code randomizeOnce}.
     * 
     * @param randomizeOnce {@code true} if the lastly laid-out parent will be only laid-out
     * randomly once and not for each {@link #layoutContainer(java.awt.Container)} subsequent call
     * for the same parent, otherwise {@code false} and each call to
     * {@link #layoutContainer(java.awt.Container)} will lay out randomly the {@link java.awt.Container}.
     */
    public RandomLayout(final boolean randomizeOnce) {
        this.randomizeOnce = randomizeOnce;
    }

    /**
     * Default constructor of {@code RandomLayout} with {@code randomizeOnce} set to {@code true}.
     */
    public RandomLayout() {
        this(true);
    }

    /**
     * If {@code true} then this {@link java.awt.LayoutManager} keeps track of the
     * {@link java.awt.Container}s laid-out to make sure that {@code lastParent} is
     * only laid-out once. If the another {@link java.awt.Container} is laid-out, other
     * than {@code lastParent}, then its components are laid-out randomly and the
     * {@link java.awt.Container} becomes the {@code lastParent}.
     * 
     * @param randomizeOnce {@code true} if the lastly laid-out parent will be only laid-out
     * randomly once and not for each {@link #layoutContainer(java.awt.Container)} subsequent call
     * for the same parent, otherwise {@code false}.
     */
    public void setRandomizeOnce(final boolean randomizeOnce) {
        this.randomizeOnce = randomizeOnce;
    }

    /**
     * Tells if the lastly laid-out parent will be only laid-out randomly once and not for each
     * {@link #layoutContainer(java.awt.Container)} subsequent call for the same parent, or the
     * opposite.
     * 
     * @return {@code true} if the lastly laid-out parent will be only laid-out randomly once and
     * not for each {@link #layoutContainer(java.awt.Container)} subsequent call for the same
     * parent, otherwise {@code false}.
     */
    public boolean isRandomizeOnce() {
        return randomizeOnce;
    }

    /**
     * @return The {@link java.awt.Container} which was lastly laid-out.
     */
    protected Container getLastParent() {
        return lastParent;
    }

    /**
     * @return The {@link java.awt.Insets} of {@code lastParent} the last time it was laid-out.
     * @see #getLastParent()
     */
    protected Insets getLastInsets() {
        return lastInsets;
    }

    /**
     * Adds the specified component with the specified name to the layout.
     * @param name The name of the component.
     * @param comp The {@link java.awt.Component} to be added.
     */
    public void addLayoutComponent(final String name,
                                   final Component comp) {
    }

    /**
     * Removes the specified component from the layout.
     * @param comp The {@link java.awt.Component} to be removed.
     */
    public void removeLayoutComponent(final Component comp) {
    }

    /** 
     * {@inheritDoc}
     * @return The preferred size dimensions for the specified {@link java.awt.Container}.
     */
    @Override
    public Dimension preferredLayoutSize(final Container parent) {
        final Dimension prefDim = minimumLayoutSize(parent);
        prefDim.width += 2; //+2 to spare.
        prefDim.height += 2; //+2 to spare.
        return prefDim;
    }

    /**
     * {@inheritDoc}
     * @return The minimum size dimensions for the specified {@link java.awt.Container}.
     */
    @Override
    public Dimension minimumLayoutSize(final Container parent) {
        final Dimension minDim = new Dimension();

        final int childCnt = parent.getComponentCount();
        for (int i=0; i<childCnt; ++i)
            applyBigger(minDim, getPreferredSize(parent, parent.getComponent(i)));

        final Insets parInsets = parent.getInsets();
        minDim.width += (parInsets.left + parInsets.right);
        minDim.height += (parInsets.top + parInsets.bottom);

        return minDim;
    }

    /**
     * {@inheritDoc}. If the another {@link java.awt.Container} is laid-out, other
     * than {@code lastParent}, then its components are laid-out randomly and the
     * {@link java.awt.Container} becomes the {@code lastParent}.
     */
    @Override
    public void layoutContainer(final Container parent) {
        if (parent == null)
            throw new IllegalArgumentException("Cannot lay out null.");
        if (isRandomizeOnce() && lastParent == parent) { //At least take care of insets (if they have changed).
            final Insets parentInsets = parent.getInsets();
            if (!lastInsets.equals(parentInsets)) {
                final int offx = parentInsets.left - lastInsets.left,
                          offy = parentInsets.top - lastInsets.top;

                final int childCnt = parent.getComponentCount();
                for (int i=0; i<childCnt; ++i) {
                    final Component child = parent.getComponent(i);
                    final Point childLoca = child.getLocation();
                    childLoca.x += offx;
                    childLoca.y += offy;
                    child.setLocation(childLoca);
                }

                lastInsets = parentInsets;
            }
        }
        else
            layoutContainerRandomly(parent);
    }

    /**
     * Explicitly lays out randomly the specified container.
     * <p>
     * This is equivalent of calling:
     * <pre>
     * boolean isRand1 = randomLayout.isRandomizeOnce();
     * randomLayout.setRandomizeOnce(false);
     * randomLayout.layoutContainer(parent);
     * randomLayout.setRandomizeOnce(isRand1);
     * </pre>
     * {@code parent} becomes {@code lastParent}.
     * </p>
     * @param parent The container to be laid out.
     */
    public void layoutContainerRandomly(final Container parent) { //Place each child at a random location for the "new" parent (lastParent != parent).
        if (parent == null)
            throw new IllegalArgumentException("Cannot lay out null.");

        reset();

        final Dimension parentSize = parent.getSize();
        final Insets parentInsets = parent.getInsets();
        final Dimension childSize = new Dimension();
        final Point childLoca = new Point();
        final Random rand = new Random();

        final int childCnt = parent.getComponentCount();
        for (int i=0; i<childCnt; ++i) {
            final Component child = parent.getComponent(i);

            child.getSize(childSize);

            childLoca.x = parentInsets.left + 1;
            childLoca.y = parentInsets.top + 1;

            final int xBound = parentSize.width - parentInsets.left - parentInsets.right - childSize.width,
                      yBound = parentSize.height - parentInsets.top - parentInsets.bottom - childSize.height;

            if (xBound > 0)
                childLoca.x += rand.nextInt(xBound);
            if (yBound > 0)
                childLoca.y += rand.nextInt(yBound);

            child.setLocation(childLoca);
        }

        lastParent = parent;
        lastInsets = parentInsets;
    }

    /**
     * Invalidates the tracking of the lastly laid-out {@link java.awt.Container} and its last
     * {@link java.awt.Insets}.
     * @see #getLastParent()
     * @see #getLastInsets()
     */
    protected void reset() {
        lastParent = null;
        lastInsets = null;
    }

    private static void applyBigger(final Dimension inputOutput,
                                    final Dimension input) {
        if (inputOutput != null && input != null) {
            inputOutput.width = (int) Math.max(inputOutput.width, input.width);
            inputOutput.height = (int) Math.max(inputOutput.height, input.height);
        }
    }

    private static void applyIfBetter(final Dimension inputOutput,
                                      final Dimension input) {
        if (inputOutput != null && input != null
            && (input.width > inputOutput.width
                || input.height > inputOutput.height)) {
            inputOutput.width = input.width;
            inputOutput.height = input.height;
        }
    }

    /**
     * Tries to determine the best size for {@code child}.
     * @param parnt The parent {@link java.awt.Container} being laid-out.
     * @param child The child {@link java.awt.Component} of {@code parnt} being laid-out.
     * @return A preferred size for the {@code child} to be laid-out.
     */
    protected static Dimension getPreferredSize(final Container parnt,
                                                final Component child) {
        final Dimension minDim = new Dimension();
        if (child != null) {
            applyIfBetter(minDim, child.getMinimumSize());
            applyIfBetter(minDim, child.getSize());
            applyIfBetter(minDim, child.getPreferredSize());
        }
        return minDim;
    }
}