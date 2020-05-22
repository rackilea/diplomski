Something something1 = applicationContext.getBean(Something.class);
    Something something2 = applicationContext.getBean(Something.class);

    Assert.assertEquals(something1, something1);
    Assert.assertNotEquals(something1, something2);

    something1.doWhatever();
    something2.doWhatever();