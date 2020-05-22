@Asynchronous
public Future<String> sayHelloAsync() 
{
     //do something time consuming ...
     return new AsyncResult<String>("Hello world");
}