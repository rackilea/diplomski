public class Item
{
    private String itemName;
    private List<Item> subItems = new List<Item>();

    public void Push(string[] namespaces, int index)
    {
        if (index >= namespaces.Length)
            return;

        foreach (Item child in subItems)
        {
            if (child.itemName == namespaces[index])
            {
                child.Push(namespaces, index + 1);
                return;
            }
        }

        Item newChild = new Item();
        newChild.itemName = namespaces[index];
        newChild.Push(namespaces, index + 1);
        subItems.Add(newChild);
    }
}

private static void Namespaces()
{
    String s1 = "com.mycompany.project.dao.hibernate.BaseDAOHibernate";
    String s2 = "com.mycompany.project.domain.Product";
    String s3 = "com.mycompany.project.domain.ProductCategory";
    String s4 = "com.mycompany.project.service.impl.ProductServiceImpl";
    String s5 = "com.mycompany.project.domain.User";
    String s6 = "com.mycompany.project.service.impl.ProductCategoryServiceImpl";
    String s7 = "com.mycompany.project.dao.hibernate.ProductCategoryDAOHibernate";
    String s8 = "com.mycompany.project.dao.hibernate.ProductDAOHibernate";

    String[] strings = { s1, s2, s3, s4, s5, s6, s7, s8 };

    Item root = new Item();
    foreach (string s in strings)
    {
        root.Push(s.Split('.'), 0);
    }
    // Do something with root variable.
}