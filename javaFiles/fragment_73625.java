if (task instanceof MacroDef) {
              MacroDef macroDef = (MacroDef)task;
              // a Sequence element, but not really, as `unkSeq.getRealThing()` will return null
              UnknownElement unkSeq = macroDef.getNestedTask();
              // Make sure we are dealing with the wrapper, or we won't get very far
              RuntimeConfigurable wrapper = unkSeq.getWrapper();
              // Wrappers can be configured too.
              wrapper.maybeConfigure(project, true);
              Enumeration enumeration = wrapper.getChildren();
              while (enumeration.hasMoreElements()) {
                // children of the wrapper
                RuntimeConfigurable child = (RuntimeConfigurable) enumeration.nextElement();
                UnknownElement unkchild = (UnknownElement)child.getProxy();
                // you can use this to print the name
                System.out.println("child(wrapper): " + unkchild.getTaskName());
                // this will be null, as the macro hasn't "executed"
                System.out.println("child(real): " + unkchild.getRealThing());
              }
            }