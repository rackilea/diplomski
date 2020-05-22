967 // Creates the initial Thread
 968 static oop create_initial_thread(Handle thread_group, JavaThread* thread, TRAPS) {
 969   klassOop k = SystemDictionary::resolve_or_fail(vmSymbols::java_lang_Thread(), true, CHECK_     NULL);
 970   instanceKlassHandle klass (THREAD, k);
 971   instanceHandle thread_oop = klass->allocate_instance_handle(CHECK_NULL);
 972 
 973   java_lang_Thread::set_thread(thread_oop(), thread);
 974   java_lang_Thread::set_priority(thread_oop(), NormPriority);
 975   thread->set_threadObj(thread_oop());
 976 
 977   Handle string = java_lang_String::create_from_str("main", CHECK_NULL);
 978 
 979   JavaValue result(T_VOID);
 980   JavaCalls::call_special(&result, thread_oop,
 981                                    klass,
 982                                    vmSymbols::object_initializer_name(),
 983                                    vmSymbols::threadgroup_string_void_signature(),
 984                                    thread_group,
 985                                    string,
 986                                    CHECK_NULL);
 987   return thread_oop();
 988 }