configurations {
            developmentOnly
            runtimeClasspath {
                extendsFrom developmentOnly
            }
        }

        dependencies {
            implementation {
                'org.springframework.boot:spring-boot-devtools'
                ':spring-boot-app'
                'org.springframework.boot:spring-boot-starter-web'

            }
        }