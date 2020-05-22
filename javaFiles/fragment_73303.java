synchronized (getHolder()) {
        update();
        onDraw(c);
    }


    update(){
        for every object
            object.update()
    }

    onDraw(){
        for every object
            object.draw()
    }