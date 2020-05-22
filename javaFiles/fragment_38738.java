Principal principal = new Principal() {

        @Override
        public String getName() {
            return adminName;
        }

    }
apiService.create(principal, urlinfo);