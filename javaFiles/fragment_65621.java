...
        } finally {
            try {
                new MyResource("finally").close();
            } catch (Exception e) {
                if (exceptionFromCatch!=null) {
                    exceptionFromCatch.addSuppressed(e);
                } else {
                    throw e;
                }
            }
        }
...