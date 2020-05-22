[ServiceContract]
public interface ICalculatorService
{
    [OperationContract]
    int Add(int firstValue, int secondValue);
}