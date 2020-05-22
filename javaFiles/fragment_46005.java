public void setVisible(boolean visible) {
    if (!visible){
        this.clearChildren();
    } else {
        this.add(new Label("Name: " + getCalledBy().getName(), getSkin()));
        this.row();
        this.add(new Label("Attack: " + getCalledBy().getAttack(), getSkin()));
        this.row();
        this.add(new Label("Defense: " + getCalledBy().getDefense(), getSkin()));
        this.row();
        this.add(new Label("Health: " + getCalledBy().getHealth(), getSkin()));
    }
    super.setVisible(visible);
}