Image text = new Image(clickToStartRegion);
 Float fadeTime = 1f;

 //...

 text.addAction(Actions.alpha(0)); //make the text transparent.
 text.act(0); //update the text once
 text.addAction(Actions.sequence(Actions.fadeIn(fadeTime), Actions.fadeOut(fadeTime));

 //...

 text.act(deltaTime);

 //...

 text.draw(batch, 1);