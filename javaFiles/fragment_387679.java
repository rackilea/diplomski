/**
     * When an existing singleTask activity is launched, 
     * all other activities above it in the stack will be destroyed.
     * It's different when launchMode is "Standard". 
     * The task which contains flag will come to the foreground 
     * and keep the state the same as before.
     * When you press HOME and launch the activity again, 
     * ActivityManger calls an intent
     *     {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER]
     *      flag=FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_RESET_IF_NEEDED cmp=A}    
     */

 Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP;