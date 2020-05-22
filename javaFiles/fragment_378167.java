JavaVMInitArgs vm_args;
JavaVMOption options[4];

options[0].optionString = "-Djava.compiler=NONE";           /* disable JIT */
options[1].optionString = "-Djava.class.path=c:\myclasses"; /* user classes */
options[2].optionString = "-Djava.library.path=c:\mylibs";  /* set native library path */
options[3].optionString = "-verbose:jni";                   /* print JNI-related messages */

vm_args.version = JNI_VERSION_1_2;
vm_args.options = options;
vm_args.nOptions = 4;
vm_args.ignoreUnrecognized = TRUE;

/* Note that in the JDK, there is no longer any need to call 
 * JNI_GetDefaultJavaVMInitArgs. 
 */
res = JNI_CreateJavaVM(&vm, (void **)&env, &vm_args);
if (res < 0) ...