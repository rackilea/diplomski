if(counter <= 3 && counter > 2 && !condition1) {   
    stage.addActor(oneImg);
    condition1 = true;
} else if(counter <= 2 && counter > 1 && !condition2) {
    stage.addActor(twoImg);
    condition2 = true;
} else if(counter <= 1 && counter > 0 && !condition3)  {
    stage.addActor(splashImg);
    condition3 = true;
}