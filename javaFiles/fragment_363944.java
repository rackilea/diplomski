public interface Tag extends JspTag {

...

/**
 * Called on a Tag handler to release state.
 * The page compiler guarantees that JSP page implementation
 * objects will invoke this method on all tag handlers,
 * but there may be multiple invocations on doStartTag and doEndTag in between.
 */

void release();

...

}