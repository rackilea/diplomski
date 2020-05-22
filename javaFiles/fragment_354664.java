package com.example.trusted.launcher;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Policy;
import java.util.Collections;

import com.example.trusted.security.DenyingPolicy;

public class Launcher {

    public static void main(String... args) throws Exception {

        /*
         * Get the actual main application class, which has hopefully been loaded by a different ClassLoader,
         * and resides in a distinct package and ProtectionDomain.
         */
        Class<?> realMain = getMainFromArgs(args);

        // install a Policy and SecurityManager

        /*
         * To avoid having to administer .policy configurations at the file system, you could bundle a
         * template with your app/lib, replace any CodeSource URLs you don't know until runtime, temp-save
         * to the file system (or use some transient URLStreamHandler) and "feed" the corresponding URL to
         * the Policy provider. Or better yet, if you can spare the time, implement your own Policy provider
         * as a mutable data structure.
         */
        String policyConfig = new String(
                Files.readAllBytes(Paths.get(Launcher.class.getResource("policy_template.txt").toURI())),
                StandardCharsets.UTF_8);

        // replace any CodeSource URL placeholders (e.g. with realMain's cs URL)
        policyConfig = adjustPolicyConfig(policyConfig);

        // temp-save it and hand it over to Policy
        Path tmpPolicyFile = Files.createTempFile("policy", ".tmp");
        Files.write(tmpPolicyFile, Collections.singletonList(policyConfig));

        // leading equals sign ensures only the indicated config gets loaded
        System.setProperty("java.security.policy", "=" + tmpPolicyFile.toUri());

        // unnecessary if you don't care about deny rules
        Policy.setPolicy(new DenyingPolicy());

        System.setSecurityManager(new SecurityManager());

        Files.delete(tmpPolicyFile);

        // filter args and call real main
        invokeMain(realMain, args);
    }

    // ...

}