JClass annotatedType = jcmSource.ref(Class.class);

    JInvocation m =  annotatedType.staticInvoke("forName");
    m.arg(fa.getAnnotated().toString());

    JFieldVar field = sourceClass.field(
            JMod.PRIVATE | JMod.STATIC, annotatedType, "c");

    JBlock staticInit = sourceClass.init();

    JTryBlock tb = staticInit._try();
    JBlock jbtb = tb.body();
        jbtb.assign(field, m);
    tb._catch(jcmSource.ref(ClassNotFoundException.class));