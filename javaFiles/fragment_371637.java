const bool is_system_gc = gc_cause == GCCause::_java_lang_system_gc;

// This is useful for debugging but don't change the output the
// the customer sees.
const char* gc_cause_str = "Full GC";
if (is_system_gc && PrintGCDetails) {
  gc_cause_str = "Full GC (System)";
}