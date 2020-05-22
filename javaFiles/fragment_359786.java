// The method pointer in the frame might be the only path to the method's
// klass, and the klass needs to be kept alive while executing. The GCs
// don't trace through method pointers, so typically in similar situations
// the mirror or the class loader of the klass are installed as a GC root.
// To minimze the overhead of doing that here, we ask the GC to pass down a
// closure that knows how to keep klasses alive given a ClassLoaderData.
cld_f->do_cld(m->method_holder()->class_loader_data());