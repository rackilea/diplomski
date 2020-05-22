for (MenuButton m : menuButtonList) {
    if((m.isVertical()==vertical||order==1)&&m.getOrder()+1==order ){
        // ...
        MenuButton m2=new MenuButton(order,b , vertical, p,name);
        menuButtonList.add(m2);
        // ...
    }
}