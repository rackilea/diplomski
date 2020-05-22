service.submit(new Service1(conn) {
                public Object call(){
                    try {
                        process(conn, param2); // Passing connection & obj
                    } catch (Exception e) {
                        throw e;
                    }
                    return null;
                }
            });