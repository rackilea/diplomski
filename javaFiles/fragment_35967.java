public void changeName(String name){
    Condition copy = new Condition(this.name);
    copy.lastCondition = this.lastCondition;
    this.lastCondition = copy;
    this.name = name;
}