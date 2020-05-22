public interface TransferDataStrategy<MODEL>
{
    MODEL getModel();

    OptionStrategy getOptionStrategy();
}