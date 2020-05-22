static GstFlowReturn new_buffer (GstAppSink *app_sink, gpointer user_data)
{
  char* pipe_name = (char*) user_data;
  GstBuffer* buffer = gst_app_sink_pull_buffer(app_sink);

//  g_debug("appsink buffer timestamp(%lli) size(%d)",
//          GST_BUFFER_TIMESTAMP(buffer),
//          GST_BUFFER_SIZE(buffer));

  g_print((char*)buffer);

  gst_buffer_unref(buffer);
  return GST_FLOW_OK;
}