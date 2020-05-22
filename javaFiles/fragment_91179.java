setDecoratedDynaObjectList(rsdc.getRows());
    Iterator<DynaBean> it=decoratedDynaObjectList.iterator();
    while(it.hasNext()){
        BasicDynaBean dynaBean = (BasicDynaBean) it.next();
        Map<String,Object> modifiableMap=new DynaBeanPropertyMapDecorator(dynaBean, false);
        DynaBean mutableDynaBean=new LazyDynaMap(modifiableMap);
        modifiableDynaObjectList.add(mutableDynaBean);
    }