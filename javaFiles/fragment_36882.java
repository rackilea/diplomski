public privileged aspect ClassLoadTestAspect {
    static boolean active = true;

    declare precedence : ClassLoadTestAspect, ClassLoadAspect;
    pointcut classLoadAspect() :
        if(active) && 
        withincode(ClassLoadAspect.new()) && 
        call(* OwlApiRepository.getInstance());

    Object around() : classLoadAspect() {
        return new MockRepository();
    }
}