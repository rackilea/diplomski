public interface Containter<Z extends ModelElement> extends ModelElement{      
    List<Z> getChildren(); 
}

public class MockMama {    
    public static <Y extends ModelElement, T extends Containter<Y>> T bornContainer( Class<T> clazz, Y ... children) {            
        T container = mock(clazz);            
        when(container.getChildren()).thenReturn( Arrays.asList(children));            
        return container;    
    } 
}