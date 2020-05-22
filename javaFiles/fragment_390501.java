private HashMap<Class, BaseProcess> processMap;

public Process(HashMap<Class, BaseProcess> processMap)
{
   this.processMap = processMap;
}

public void process(BaseObject objectInstance)
{
   //"which returns ProcessClass?:BaseClass"
   processMap.get(objectInstance.getClass()).process(objectInstance);
}