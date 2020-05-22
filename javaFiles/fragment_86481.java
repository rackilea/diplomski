(snippet)
@OneToMany(mappedBy = "e1", fetch = FetchType.EAGER)
@MapKey(name="iCantFigureTheRightPropertyName")
public Map<String, Entity2> getE2s() {  
    return e2s;  
}