class ScopeTest {
    public void outside(String[] args) {
        Integer total = 0; 
        Integer i; 
        for (String str : args) 
        { 
            i = Integer.valueOf(str); 
            total += i; 
        }
    }
    public void inside(String[] args) { 
        Integer total = 0; 
        for (String str : args) 
        { 
            Integer i = Integer.valueOf(str); 
            total += i; 
        }
    }
}