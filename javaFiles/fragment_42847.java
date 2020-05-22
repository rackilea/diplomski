void WebContentsAndroid::EvaluateJavaScript(JNIEnv* env,
                                                jobject obj,
                                                jstring script,
                                                jobject callback) {
   RenderViewHost* rvh = web_contents_->GetRenderViewHost();
   DCHECK(rvh);
   if (!rvh->IsRenderViewLive()) {
     if (!static_cast<WebContentsImpl*>(web_contents_)->
         CreateRenderViewForInitialEmptyDocument()) {
         ...
        }
      }
   ....