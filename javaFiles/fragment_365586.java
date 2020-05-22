// Set default crypto suite for HF client
    client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());

    client.setUserContext(new User() {

        public String getName() {
            return "testUser";
        }

        public Set<String> getRoles() {
            return null;
        }

        public String getAccount() {
            return null;
        }

        public String getAffiliation() {
            return null;
        }

        public Enrollment getEnrollment() {
            return new Enrollment() {
                public PrivateKey getKey() {
                    // Load your private key
                }

                public String getCert() {
                    // Read client certificate
                }
            };
        }

        public String getMspId() {
            return "Org1MSP";
        }
    });