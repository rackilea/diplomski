private List<Serializable> content;

@XmlElementRef(name = "protectedText", type = ProtectedText.class)
@XmlMixed
public List<Serializable> getContent(){
    return content;
}

public void setContent(List<Serializable> content){
    this.content = content;
}