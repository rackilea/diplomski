Routing:
  name: ROUTING_APPENDER
  Routes:
    pattern: "$${marker:}"
    Route:
    - key: PERFORMANCE
      ref: PERFORMANCE_APPENDER
    - key: PAYLOAD
      ref: PAYLOAD_APPENDER
    - key: FATAL
      ref: FATAL_APPENDER
    - ref: APPLICATION_APPENDER #Default route