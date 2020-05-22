public static Salad createSaladInstance(String type)
{
    if(type.equals("Salad")) return new Salad();
    else if(type.equals("ChefSalad")) return new ChefSalad();
    // ...
}

// ...

Salad s = createSaladInstance(type);