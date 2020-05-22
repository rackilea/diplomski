@Override
protected void init(VaadinRequest request) {
    BeanContainer<Long, DecemberBean> dataSource = new BeanContainer<Long, DecemberBean>(DecemberBean.class);
    Grid grid = new Grid(dataSource);
    Runnable r = () -> {
        while (true) {
            System.out.println("update");
            try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();};
            UI.getCurrent().access(() -> {
                for (Long item : dataSource.getItemIds()) {
                    DecemberBean k = dataSource.getItem(item).getBean();
                    k.setNumber(k.getNumber() + 100);
                }
                grid.sort(grid.getContainerDataSource().getContainerPropertyIds().iterator().next());
            });
        }
    };
    dataSource.setBeanIdResolver(bean -> new Long(bean.getNumber()));
    for (int i = 0; i < 100; i++) {
        dataSource.addBean(new DecemberBean(i));
    }
    setContent(grid);
    new Thread(r).start();
}