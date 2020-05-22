#[no_mangle]
pub extern "system" fn Java_Main_analyze(env: JNIEnv, class: JClass, obj: JObject) {
    unsafe {
        // It should have been transmuted to a pointer to a pointer and dereferenced twice.
        let indirect = mem::transmute::<_, *const *const Point>(*obj);
        println!("{:?}", **indirect);
    }
}