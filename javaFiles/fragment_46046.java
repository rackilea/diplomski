Manifest-Version: 1.0
Bundle-ManifestVersion: 2
Bundle-Name: %plugin.name
Bundle-SymbolicName: greg.music.ogg;singleton:=true
Bundle-Version: 2.0.0.qualifier
Bundle-Vendor: %plugin.provider
Bundle-Localization: plugin
Require-Bundle: greg.music.core;bundle-version="1.0.0",
 greg.music.resources;bundle-version="1.0.0",
 org.eclipse.core.runtime,
 javazoom.jlgui.basicplayer,
 org.eclipse.e4.core.services;bundle-version="2.0.100"
Bundle-ClassPath: .,
 lib/jogg-0.0.7.jar,
 lib/jorbis-0.0.15.jar,
 lib/vorbisspi1.0.2.jar
Bundle-RequiredExecutionEnvironment: JavaSE-9
Import-Package: javax.annotation;version="1.0.0",
 javax.inject;version="1.0.0",
 org.eclipse.e4.core.di.annotations