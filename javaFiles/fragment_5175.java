if(parts[0].equals("ContainerPositionsMaritime"))
        {
            final ContainersOnBoard containers = receivedString.split(";");
            mainApp.enqueue(new Callable<Spatial>() {
                public Spatial call() throws Exception {
                    mainApp.InitContainers(containers);
                    return null;
                }
            });                   
            }

        }