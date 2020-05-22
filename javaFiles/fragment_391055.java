Grid<Car> grid = new Grid<Car>();
grid.addColumn(Car::getPerson).setComparator((car1, car2) -> 
{
    // ignoring any null checks for getPerson() as they can be null.
    return car1.getPerson().compareTo(car2.getPerson());               
});