package com.sysvana.router.config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
public class Test {
static String hostname = "10.1.10.60";
static String username = "administrator";
static String password = "P@ssw0rd"; 
public static void main(String[] args) throws IOException {
Connection conn = new Connection(hostname);
conn.connect();
boolean isAuthenticated = conn.authenticateWithPassword (username, password);
if (isAuthenticated == false){
System.out.println("authentication failed");
} 
System.out.println(isAuthenticated);
Session sess = conn.openSession (); 
sess.execCommand ("powershell C:/Users/Administrator/Desktop/test.ps1"); 
InputStream stdout = new StreamGobbler (sess.getStdout ()); 
BufferedReader br = new BufferedReader (new InputStreamReader (stdout));
while (true)
{
String line = br.readLine ();
if (line == null) break;
System.out.println (line);
}
System.out.println ("Exit code" + sess.getExitStatus ());
sess.close ();
conn.close ();
}
}