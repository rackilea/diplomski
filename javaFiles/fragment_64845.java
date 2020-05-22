--- demo-old.java   2012-01-25 23:12:54.000000000 +0530
+++ demo.java   2012-01-25 23:13:45.000000000 +0530
@@ -10,4 +10,3 @@

-void read_graph() {
-    Scanner sc = new Scanner(System.in);
+void read_graph(Scanner sc) {
     N = sc.nextInt();
@@ -26,4 +25,3 @@

-void query(){
-Scanner sc = new Scanner(System.in);
+void query(Scanner sc){
     int P, Q;
@@ -53,4 +51,4 @@
     while (numGraphs>0){
-        G.read_graph();
-        G.query();
+        G.read_graph(sc);
+        G.query(sc);
         numGraphs--;