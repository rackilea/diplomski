diff --git a/src/xcb_io.c b/src/xcb_io.c
index 300ef57..8616dce 100644
--- a/src/xcb_io.c
+++ b/src/xcb_io.c
@@ -454,7 +454,7 @@ void _XSend(Display *dpy, const char *data, long size)
        static const xReq dummy_request;
        static char const pad[3];
        struct iovec vec[3];
-       uint64_t requests;
+       unsigned long requests;
        _XExtension *ext;
        xcb_connection_t *c = dpy->xcb->connection;
        if(dpy->flags & XlibDisplayIOError)
@@ -470,7 +470,7 @@ void _XSend(Display *dpy, const char *data, long size)
        if(dpy->xcb->event_owner != XlibOwnsEventQueue || dpy->async_handlers)
        {
                uint64_t sequence;
-               for(sequence = dpy->xcb->last_flushed + 1; sequence <= dpy->request; ++sequence)
+               for(sequence = dpy->xcb->last_flushed + 1; (unsigned long) sequence <= dpy->request; ++sequence)
                        append_pending_request(dpy, sequence);
        }
        requests = dpy->request - dpy->xcb->last_flushed;