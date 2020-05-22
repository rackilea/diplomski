public void swap(){
    for(Entity en:entityList){
        if((en instanceof Block)&&(en.position.equals(agent.position)){
                    //                 ^here is "en" instead of block
            System.out.println("Agent overlab block: "+en);
            en.previousPosition=new Dimension(
                    en.position.width,
                    en.position.height);
            en.setPosition(agent.previousPosition);
        }
    }
}