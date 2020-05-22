@Override
public boolean equals(Object o){
    if (this == o) return true;
    if (!(o instanceof Pizza)) return false;

    Pizza pizza = (Pizza) o;

    return getStrength() == pizza.getStrength();
}