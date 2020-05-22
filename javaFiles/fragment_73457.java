// callback notification that MapReduce run has completed   
JNIEXPORT jobject JNICALL com_sfoam_hpcmom_mapreduce_bridge_BridgeClient_runCompletedCallback(JNIEnv* env, jobject obj, jlong ptr) {
    log_info << "callback 'run completed' received";
    MapReduceBridge * ptr = (MapReduceBridge *)ptr;
    //Use ptr now to reference your instance variables
    //callback_condition_.notify_one();
}
void MapReduceBridge::run() {
    // get BridgeClient's method run and invoke it
    env_->CallObjectMethod(bridge_instance_, bridge_run_, (long)this );
    log_info << "run method launched";

    // wait for the callback that 'run' has completed
    callback_condition_.wait(lock_);
}