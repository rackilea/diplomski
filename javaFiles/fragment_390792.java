private boolean isDefault(final FacebookChannelConfig channelConfig) {
        if (configRepository.getDefault() != null
                    && configRepository.getDefault().getId().toString()
                            .equals(channelConfig.getId().toString())) {
            return true;
        }
        return false;
    }