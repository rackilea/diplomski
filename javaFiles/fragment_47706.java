Test<String> test = new Test<String>();//Comparable class
    test.compareMethod("",String.class);//works fine
    Test<Random> tes1t = new Test<Random>();//Non Comparable class
    tes1t.compareMethod(new Random(),Random.class);//Compilation error here 
    tes1t.normalMethod(new Random());//Works fine
    new Test<Random>().compareMethod("",String.class);// Not a good but can be valid
new Test<String>().compareMethod(new Random(),Random.class);//Compilation error here