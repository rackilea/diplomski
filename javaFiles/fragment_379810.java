@Override
public boolean equals(Object other){
    if (!(other instanceof Animal))
        return false;
    Animal otherAnimal = (Animal) other;
    return (this.legs==otherAnimal.legs) && 
           (this.getClass().getName().equals(otherAnimal.getClass().getName()));
}