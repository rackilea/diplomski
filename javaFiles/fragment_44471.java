jdk7-ee67ee3bd597/hotspot/src/share$ egrep -h -A2 -B5 -r '"\-\-"' *
# G1 Collector
if (evacuation_failed()) {
  remove_self_forwarding_pointers();
  if (PrintGCDetails) {
    gclog_or_tty->print(" (to-space overflow)");
  } else if (PrintGC) {
    gclog_or_tty->print("--");
  }
}
--
# Parallel Scavenge Collector
promotion_failure_occurred = promotion_failed();
if (promotion_failure_occurred) {
  clean_up_failed_promotion();
  if (PrintGC) {
    gclog_or_tty->print("--");
  }
}