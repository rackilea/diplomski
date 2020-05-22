table = new Table();
    table.setDebug(true);
    table.top().left();
    table.add(lock1).width(lock1.getWidth()).height(lock1.getHeight()).left().top();
    table.row();
    table.row();
    table.add(lock2).width(lock2.getWidth()).height(lock2.getHeight()).left().bottom();