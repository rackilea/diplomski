repositories {
  mavenCentral()
  jcenter()

  //decoder library, will soon be on jcenter 
  maven { url 'https://dl.bintray.com/n42/maven'} 
}

dependencies {
  compile 'com.davemorrissey.labs:subsampling-scale-image-view:3.5.0'
  compile 'com.github.castorflex.verticalviewpager:library:19.0.1'
  compile 'de.number42:subsampling-pdf-decoder:0.1.0@aar'
}