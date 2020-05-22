package org.example

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.support.PathMatchingResourcePatternResolver

@SpringBootApplication
class ResourceDemoApplication implements CommandLineRunner {

    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver()

    static void main(String[] args) {
        SpringApplication.run ResourceDemoApplication, args
    }

    @Override
    void run(String... arg0) throws Exception {
        retrieveDirectory()
    }

    void retrieveDirectory() {
        List<FileSystemResource> files = resolver.findPathMatchingResources('private/folders/**/example.txt')

        files.each { file ->
            println file.getInputStream().text
        }
    }
}