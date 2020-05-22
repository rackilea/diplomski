{
    "message": "",
    "command": "http-listener-1",
    "exit_code": "SUCCESS",
    "extraProperties": {
        "commands": [
            {
                "path": "create-ssl",
                "method": "POST",
                "command": "create-ssl"
            }
        ],
        "methods": [
            {
                "name": "GET"
            },
            {},
            {
                "messageParameters": {
                    "address": {
                        "defaultValue": "0.0.0.0",
                        "optional": "true",
                        "type": "string",
                        "key": "false"
                    },
                    "enabled": {
                        "defaultValue": "true",
                        "optional": "true",
                        "type": "boolean",
                        "key": "false"
                    },
                    "jkConfigurationFile": {
                        "defaultValue": "${com.sun.aas.instanceRoot}/config/glassfish-jk.properties",
                        "optional": "true",
                        "type": "string",
                        "key": "false"
                    },
                    "jkEnabled": {
                        "defaultValue": "false",
                        "optional": "true",
                        "type": "boolean",
                        "key": "false"
                    },
                    "name": {
                        "optional": "false",
                        "type": "string",
                        "key": "true"
                    },
                    "port": {
                        "optional": "false",
                        "type": "int",
                        "key": "false"
                    },
                    "protocol": {
                        "optional": "false",
                        "type": "string",
                        "key": "false"
                    },
                    "threadPool": {
                        "optional": "true",
                        "type": "string",
                        "key": "false"
                    },
                    "transport": {
                        "optional": "false",
                        "type": "string",
                        "key": "false"
                    }
                },
                "name": "POST"
            },
            {
                "messageParameters": {
                    "target": {
                        "acceptableValues": "",
                        "defaultValue": "server",
                        "optional": "true",
                        "type": "string"
                    }
                },
                "name": "DELETE"
            }
        ],
        "entity": {
            "address": "0.0.0.0",
            "enabled": "true",
            "jkConfigurationFile": "${com.sun.aas.instanceRoot}/config/glassfish-jk.properties",
            "jkEnabled": "false",
            "name": "http-listener-1",
            "port": "8080",
            "protocol": "http-listener-1",
            "threadPool": "http-thread-pool",
            "transport": "tcp"
        },
        "childResources": {
            "find-http-protocol": "http://localhost:4848/management/domain/configs/config/server-config/network-config/network-listeners/network-listener/http-listener-1/find-http-protocol",
            "property": "http://localhost:4848/management/domain/configs/config/server-config/network-config/network-listeners/network-listener/http-listener-1/property"
        }
    }
}