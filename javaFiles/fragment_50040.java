[ServiceContract]
public interface ISimpleTest
{
    [OperationContract]
    int Add(int a, int b);
}