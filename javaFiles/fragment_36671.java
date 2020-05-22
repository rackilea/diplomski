public List<ValidationError> validateBooking(/* args */)
{
    // as @Jared Farrish suggests, return a list of validation errors
}

public boolean saveBooking(/* args */)
{
    List<ValidationError> errors = validateBooking(/* args */);

    if (errors.size() != 0) return false; // validation failed

    // save to the database

    return true;
}