class MyApp
{
    Entity e = new Entity();
    e.setAttribute(Attribute.NAME, "Bob");
    e.setAttribute(Attribute.AGE, 55);
    e.setAttribute(Attrbute.HEIGHT, 5.5f);

    string name = e.getAttribute(Attribute.NAME);
    int age = e.getAttribute(Attribute.AGE);
    float height = e.setAttribute(Attribute.HEIGHT);
}