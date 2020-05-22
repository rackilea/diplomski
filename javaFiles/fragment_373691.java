Example target = new Example();
...

Class targetClass = target.getClass();
return MethodHandles.lookup()
                    .in(targetClass)
                    .unreflectSpecial(method, targetClass)
                    .bindTo(target)
                    .invokeWithArguments();