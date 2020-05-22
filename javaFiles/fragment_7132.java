for (Field f : loadedClass.getDeclaredFields()) {
                System.out.println(f.getName());
                for (Annotation a : f.getAnnotations()) {
                    System.out.println("## SHOWING ANNOTATION FOR FIELD:" + f.getName());
                    System.out.println(a.toString());
                }


            }