/**
 * @return The car.
 */
public Car getCar() {
    return car;
}

/**
 * @param car
 *            The car to set.
 */
public void setCar(Car car) {
    this.car = car;
}

public SUV(Car car) {
    super();
    this.car = car;
}

/**
 * {@inheritDoc}
 */
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((car == null) ? 0 : car.hashCode());
    return result;
}

/**
 * {@inheritDoc}
 */
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    SUV other = (SUV) obj;
    if (car == null) {
        if (other.car != null) {
            return false;
        }
    } else if (new CarComparator().compare(car, other.car)!=0) {
        return false;
    }
    return true;
}