Instances dataset1_x=new Instances(dataset1);
RemoveByName filterX=new RemoveByName();
filterX.setInvertSelection(true);
filterX.setExpression(Pattern.quote("^.*i$"));
filterX.setInputFormat(dataset1_x);
Instances dataset1_=Filter.useFilter(dataset1_x,filterX);