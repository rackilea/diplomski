@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime
                * result
                + ((subscriberName == null) ? 0 : subscriberName.hashCode());
        result = prime
                * result
                + ((subscribingTopic == null) ? 0 : subscribingTopic
                        .hashCode());
        return result;
    }