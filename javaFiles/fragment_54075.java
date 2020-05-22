while(itr.hasNext()){
        Object obj = itr.next();
        System.out.println(obj.toString());
        if(obj instanceof TestBean){
            TestBean tb2 = (TestBean) obj;
                            tb2=modifyTestBody(tb2);
            System.out.println(tb2.getBody());
        }
        if(obj instanceof MockBean){
            MockBean mb2 = (MockBean) obj;
            System.out.println(mb2.getMockPayload());
        }
    }
    }catch(Exception e){}