3335     // Initialize java_lang.System (needed before creating the thread)
3336     if (InitializeJavaLangSystem) {
3337       initialize_class(vmSymbols::java_lang_System(), CHECK_0);
3338       initialize_class(vmSymbols::java_lang_ThreadGroup(), CHECK_0);
3339       Handle thread_group = create_initial_thread_group(CHECK_0);
3340       Universe::set_main_thread_group(thread_group());
3341       initialize_class(vmSymbols::java_lang_Thread(), CHECK_0);
3342       oop thread_object = create_initial_thread(thread_group, main_thread, CHECK_0);
3343       main_thread->set_threadObj(thread_object);
3344       // Set thread status to running since main thread has
3345       // been started and running.
3346       java_lang_Thread::set_thread_status(thread_object,
3347                                           java_lang_Thread::RUNNABLE);