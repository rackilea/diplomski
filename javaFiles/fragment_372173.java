public void getfacts( WorkingMemory workingMemory )
{
FactHandle fh;
Collection<org.kie.api.runtime.rule.FactHandle> x = workingMemory.getFactHandles();
Iterator<org.kie.api.runtime.rule.FactHandle> it =  x.iterator();

System.out.println("List of facts");
while(it.hasNext())
{
    fh = (FactHandle) it.next();

    Object getobj = workingMemory.getObject(fh);
    //System.out.println("GetObject to string: " + ((Object)getobj));

    if (getobj instanceof RuleFact) {
        System.out.println("\nIt's a Fact: ");
        ((RuleFact) getobj).print();
    }
    //System.out.println("FactHandle to string "+ ((Object) fh.toExternalForm()).toString());
   }

}