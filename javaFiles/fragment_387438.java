List<Double> widths=new ArrayList<>();

//declare all your new classes in Main and add their widths to the list
Box mybox1 = new Box();
widths.add(mybox1.width);
Box mybox2 = new Box();
widths.add(mybox2.width);

//then sum the widths
double totalWidth;
for(Double tempWidth:widths)
    totalWidth+=tempWidth;