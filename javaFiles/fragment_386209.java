;;; Dependencies, Plugins, and Repositories
  ;; Dependencies are listed as [group-id/name version]; in addition
  ;; to keywords supported by Pomegranate, you can use :native-prefix
  ;; to specify a prefix. This prefix is used to extract natives in
  ;; jars that don't adhere to the default "<os>/<arch>/" layout that
  ;; Leiningen expects.
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.jclouds/jclouds "1.0" :classifier "jdk15"]
                 [net.sf.ehcache/ehcache "2.3.1" :extension "pom"]
                 [log4j "1.2.15" :exclusions [[javax.mail/mail :extension "jar"]
                                              [javax.jms/jms :classifier "*"]
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]
                 [org.lwjgl.lwjgl/lwjgl "2.8.5"]
                 [org.lwjgl.lwjgl/lwjgl-platform "2.8.5"
                  :classifier "natives-osx"
                  ;; LWJGL stores natives in the root of the jar; this
                  ;; :native-prefix will extract them.
                  :native-prefix ""]]