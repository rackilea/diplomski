/**
 * Creates a detached criteria from the given Type and given map of filters.
 * 
 * @param type Target type the Criteria is build for.
 * @param identifierPropertyName If provided (not null) the identifier
 *            property name can be identified for the given type to simplify
 *            the queries if the identifier property is the only property
 *            used on the parent no subqueries are needed.
 * @param filters
 * 
 * @see #createTree(Set, String)
 * @see #addRestrictions(DetachedCriteria, TreeNode)
 * 
 * @return
 */
public static DetachedCriteria createDetachedCriteria(final Class<?> type, final String identifierPropertyName,
    final Map<String, Criterion> filters)
{
    final DetachedCriteria criteria = DetachedCriteria.forClass(type);

    // add restrictions using tree
    final TreeNode<Entry<String, Criterion>> rootNode = HibernateUtils2.createTree(filters.entrySet(),
        identifierPropertyName);

    final Iterator<TreeNode<Entry<String, Criterion>>> it = rootNode.getChildren().iterator();

    while (it.hasNext())
        HibernateUtils.addRestrictions(criteria, it.next());

    return criteria;
}

/**
 * Creates a Tree from the given Set using a fictional root TreeNode.
 * 
 * @param <T>
 * 
 * @param filters
 * @param identifierPropertyName Property name which is merged with its
 *            parent property. Example: <b>user.id</b> is treated as single
 *            property.
 * @return
 */
public static <T extends Object> TreeNode<Entry<String, T>> createTree(final Set<Entry<String, T>> filters,
    final String identifierPropertyName)
{

    final Iterator<Entry<String, Object>> it = filters.iterator();

    /*
     * create key property tree for Entity properties
     */
    final TreeNode<Entry<String, Object>> rootNode = new TreeNode<Entry<String, Object>>(
        new SimpleEntry<String, Object>("root", null));

    while (it.hasNext())
    {
        final Entry<String, Object> entry = it.next();
        // foo.bar.name
        final String key = entry.getKey();

        String[] props;

        /*
         * check if we have a nested hierarchy
         */
        if (key.contains("."))
        {
            props = key.split("\\.");
            // check for identifier since identifier property name does not
            // need new subcriteria
            if (!StringUtils.isBlank(identifierPropertyName))
            {
                int propsTempLength = props.length - 1;
                if (props[propsTempLength].equals(identifierPropertyName))
                {
                    props = Arrays.copyOf(props, propsTempLength);
                    propsTempLength--;
                    props[propsTempLength] = props[propsTempLength] + "." + identifierPropertyName;
                }
            }

            // check for "this" identifier of beginning, which needs to be
            // added for projections because of hibernate not recognizing it
            if (props.length > 1 && props[0].equals("this"))
            {
                props[0] = "this." + props[1];

                props = ArrayUtils.remove(props, 1);
            }
        }
        else
            props = new String[]
            {
                key
            };

        TreeNode<Entry<String, Object>> currNode = rootNode;

        // create nested criteria
        for (int i = 0; i < props.length; i++)
        {
            Object valueAdd;

            // only leaf needs value
            if (i != props.length - 1)
                valueAdd = null;
            else
                valueAdd = entry.getValue();

            final TreeNode<Entry<String, Object>> childTempNode = new TreeNode<Entry<String, Object>>(
                new SimpleEntry<String, Object>(props[i], valueAdd));

            // try to get the real node
            TreeNode<Entry<String, Object>> childNode = currNode.getChild(childTempNode.getElement());
            // check if we already have a unique node
            if (childNode == null)
            {
                childNode = childTempNode;
                // add new child to set if its a new node
                currNode.addChild(childNode);
            }

            currNode = childNode;
        }
    }

    return rootNode;
}

/**
 * Recursively adds the given Restriction's wrapped in the given TreeNode to
 * the Criteria.
 * 
 * @param criteria
 * @param treeNode
 */
public static void addRestrictions(final DetachedCriteria criteria,
    final TreeNode<Entry<String, Criterion>> treeNode)
{
    // if we have a leaf simply add restriction
    if (treeNode.getChildren().size() == 0)
        criteria.add(treeNode.getElement().getValue());
    else
    {
        // create new sub Criteria and iterate children's
        final DetachedCriteria subCriteria = criteria.createCriteria(treeNode.getElement().getKey());

        final Iterator<TreeNode<Entry<String, Criterion>>> it = treeNode.getChildren().iterator();

        while (it.hasNext())
            HibernateUtils.addRestrictions(subCriteria, it.next());
    }
}

/*
 * Utility classes
 */

/**
 * Generic TreeNode implementation with a Set to hold its children to only allow
 * unique children's.
 */
public class TreeNode<T>
{
    private final T element;

    private final Set<TreeNode<T>> childrens;

    public TreeNode(final T element)
    {
        if (element == null)
            throw new IllegalArgumentException("Element cannot be null");

        this.element = element;

        this.childrens = new HashSet<TreeNode<T>>();
    }

    public void addChildren(final TreeNode<T> children)
    {
        this.childrens.add(children);
    }

    /**
     * Retrieves the children which equals the given one.
     * 
     * @param children
     * @return If no children equals the given one returns null.
     */
    public TreeNode<T> getChildren(final TreeNode<T> children)
    {
        final Iterator<TreeNode<T>> it = this.childrens.iterator();

        TreeNode<T> next = null;

        while (it.hasNext())
        {
            next = it.next();
            if (next.equals(children))
                return next;
        }

        return null;
    }

    public T getElement()
    {
        return this.element;
    }

    public Set<TreeNode<T>> getChildrens()
    {
        return this.childrens;
    }

    /**
     * Checks if the element of this instance equals the one of the given
     * Object.
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;

        if (obj != null && obj instanceof TreeNode)
        {
            final TreeNode<?> treeNode = (TreeNode<?>) obj;

            return this.element.equals(treeNode.element);
        }
        else
            return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 1;
        hash = hash * 17 + this.element.hashCode();
        return hash;
    }
}