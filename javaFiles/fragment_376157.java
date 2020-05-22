public List<Component> getComponentsAsList (Container cont){
    List<Component> tmp = new ArrayList<>();
    for (Component c : cont.getComponents()) {
        tmp.add(c);
    }
    return tmp;
}