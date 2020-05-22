package de.scrum_master.app;

import java.util.HashMap;
import java.util.Map;

public class MDC {
  private static ThreadLocal<Map<String, String>> contextMap = new InheritableThreadLocal<>();

  static {
    clear();
  }

  public static void clear() {
    contextMap.set(new HashMap<>());
  }

  public static void put(String key, String value) {
    contextMap.get().put(key, value);
  }

  public static Map<String, String> getCopyOfContextMap() {
    return new HashMap<>(contextMap.get());
  }

  public static void setContextMap(Map<String, String> contextMap) {
    MDC.contextMap.set(contextMap);
  }
}