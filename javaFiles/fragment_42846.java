void WebContentsAndroid::EvaluateJavaScript(JNIEnv* env,
                                             jobject obj,
                                             jstring script,
                                            jobject callback,
                                            jboolean start_renderer) {

   RenderViewHost* rvh = web_contents_->GetRenderViewHost();
   DCHECK(rvh);

   if (start_renderer && !rvh->IsRenderViewLive()) {

     if (!static_cast<WebContentsImpl*>(web_contents_)->
         CreateRenderViewForInitialEmptyDocument()) {
         ... 
     }
   }
   ...