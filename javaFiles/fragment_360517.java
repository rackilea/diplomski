public class ComputerOrder extends GenericOrder<ComputerPart> {
    @Override
    public List<ComputerPart> getProducts() {
        return computerParts;
    }
}