if (task instanceof Javac) {
                Javac javac = (Javac)task;
                Path path = javac.getClasspath();
                if (path == null) {
                  System.out.println("javac: Path is null");
                } else {
                  System.out.println("javac: Path is " + path.toString());
                }
            }