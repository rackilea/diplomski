~/code/scratch/sniff: curl http://maven.dyndns.org/2/org/jvnet/animal-sniffer/1.2/animal-sniffer-1.2.jar > animal-sniffer.jar
 ~/code/scratch/sniff: curl http://repo1.maven.org/maven2/asm/asm-all/3.1/asm-all-3.1.jar > asm-all.jar
 ~/code/scratch/sniff: curl http://maven.dyndns.org/2/org/jvnet/animal-sniffer/java1.5/1.0/java1.5-1.0.sig > java1.5-1.0.sig

 ~/code/scratch/sniff: mkdir -p target/classes
 ~/code/scratch/sniff: cd !$
cd target/classes
 ~/code/scratch/sniff/target/classes: jar xf /Users/jason/usr/scala-2.8.0.RC2/lib/scala-library.jar
 ~/code/scratch/sniff/target/classes: jar xf /Users/jason/usr/scala-2.8.0.RC2/lib/scala-compiler.jar
 ~/code/scratch/sniff/target/classes: cd -
/Users/jason/code/scratch/sniff
 ~/code/scratch/sniff: scala -classpath animal-sniffer.jar:asm-all.jar
Welcome to Scala version 2.8.0.RC2 (Java HotSpot(TM) 64-Bit Server VM, Java 1.6.0_17).
Type in expressions to have them evaluated.
Type :help for more information.

scala> import org.jvnet.animal_sniffer._
import org.jvnet.animal_sniffer._

scala> import collection.JavaConversions._
import collection.JavaConversions._

scala> val ignored = collection.mutable.Set("scala/*", "ch/*", "jline/*", "org/apache/*")
ignored: scala.collection.mutable.Set[java.lang.String] = Set(org/apache/*, jline/*, scala/*, ch/*)

scala> val sc = new SignatureChecker(new java.io.FileInputStream("java1.5-1.0.sig"), ignored)
sc: org.jvnet.animal_sniffer.SignatureChecker = org.jvnet.animal_sniffer.SignatureChecker@2a65dbe8

scala> sc.process(new java.io.File("target/classes"))
Undefined reference: java/util/concurrent/locks/LockSupport.park(Ljava/lang/Object;)V in target/classes/scala/concurrent/forkjoin/ForkJoinPool$WaitQueueNode.class
Undefined reference: sun/misc/Unsafe.putOrderedObject(Ljava/lang/Object;JLjava/lang/Object;)V in target/classes/scala/concurrent/forkjoin/ForkJoinWorkerThread.class
Undefined reference: sun/misc/Unsafe.putOrderedInt(Ljava/lang/Object;JI)V in target/classes/scala/concurrent/forkjoin/ForkJoinWorkerThread.class
Undefined reference: java/util/concurrent/atomic/AtomicReferenceFieldUpdater.lazySet(Ljava/lang/Object;Ljava/lang/Object;)V in target/classes/scala/concurrent/forkjoin/LinkedTransferQueue$QNode.class
Undefined reference: java/util/concurrent/locks/LockSupport.park(Ljava/lang/Object;)V in target/classes/scala/concurrent/forkjoin/LinkedTransferQueue.class
Undefined reference: java/util/concurrent/locks/LockSupport.parkNanos(Ljava/lang/Object;J)V in target/classes/scala/concurrent/forkjoin/LinkedTransferQueue.class