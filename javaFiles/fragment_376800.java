/**
 * Retrieves id by which this component is represented within the markup. This is either the id
 * attribute set explicitly via a call to {@link #setMarkupId(String)}, id attribute defined in
 * the markup, or an automatically generated id - in that order.
 * <p>
 * If no explicit id is set this function will generate an id value that will be unique in the
 * page. This is the preferred way as there is no chance of id collision.
 * <p>
 * Note: This method should only be called after the component or its parent have been added to
 * the page.
 * 
 * @return markup id of the component
 */
public String getMarkupId()
{
    return getMarkupId(true);
}