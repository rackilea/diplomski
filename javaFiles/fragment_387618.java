public interface FormationBuilder
{
    /**
     * Builds a particular Formation implementation from the given shape.
     * Perhaps the shape is passed into the constructor of the Formation,
     * perhaps this method extracts the necessary information to build the
     * Formation...
     */
    Formation build(Shape shape);
}