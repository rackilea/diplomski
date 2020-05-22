ExecuterService workers = Executors.newFixedThreadPool(50);

    ....
    while (true) {

                this.selector.select();

                Iterator keys = this.selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = (SelectionKey) keys.next();

                    keys.remove();

                    if (! key.isValid()) {
                        continue;
                    }

                    if (key.isAcceptable()) {
                        this.accept(key);
                    }
                    else if (key.isReadable()) {
                        workers.execute(new ReadTaskHandler(key));
                    }
                    else if (key.isWritable()) {
                        workers.execute(new WriteTaskHandler(key));
                    }
                }
            }