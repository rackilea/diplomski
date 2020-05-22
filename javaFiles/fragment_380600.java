private List<SelectItem> niveis = new ArrayList<SelectItem>();
public Collection<SelectItem> getNiveis() {
if (niveis.isEmpty()) {
    this.niveis.add(new SelectItem(1, "Option 1"));
    this.niveis.add(new SelectItem(2, "Option 2"));
    this.niveis.add(new SelectItem(3, "Option 3"));
    if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil") == "ADM") {
    this.niveis.add(new SelectItem(4, "option 4"));
    }
}
return niveis;
}