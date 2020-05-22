for (WatchEvent<?> event: key.pollEvents()) 
            {
                WatchEvent.Kind<?> kind = event.kind();
                WatchEvent<Path> ev = (WatchEvent<Path>)event;                    
                Path filename = ev.context();

                Path child = dir.resolve(filename);
                if(child.toFile().isDirectory() && ev.kind() == ENTRY_CREATE )
                {
                    child.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
                }
                System.out.println(child);
            }