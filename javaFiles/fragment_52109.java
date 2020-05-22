ext {
       log4jVersion="2.5"
  }
  runtime (
            "org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion",
            "org.apache.logging.log4j:log4j-api:$log4jVersion",
            "org.apache.logging.log4j:log4j-core:$log4jVersion"
        )