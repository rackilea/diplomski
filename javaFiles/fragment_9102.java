@Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ApplicationFormAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }