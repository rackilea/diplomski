extern "C"
{
    void Java_org_cocos2dx_cpp_SceneChanger_nativeCallbackChangeScene(JNIEnv*  env, jobject thiz)
    {
        Director::getInstance()->replaceScene(MyScene::createScene());
    }
};