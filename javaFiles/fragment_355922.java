Keycloak keycloak = KeycloakBuilder
                    .builder()
                    .serverUrl(keycloakUrl)
                    .realm(keycloakRealm)
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .clientId(keycloakClientId)
                    .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
                    .build();

            return keycloak.tokenManager().getAccessToken();