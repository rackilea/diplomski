@Override
    public List<PostPayload> getByIds(@NotNull Set<UUID> issueIds) throws APIException {
        try {
            return issueIds.parallelStream()
                    .map(issueId -> {
                        try {
                            return this.getById(issueId, channelId, false);
                        } catch (IOException | APIException e) {
                            logger.error("Event='Unable to retrieve XXX ', issueId={}", issueId, e);
                            throw new UncheckedApiException("Unable to retrieve XXX  for issueId=" + issueId, e);

                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (UncheckedApiException e) {
            throw new APIException(e);
        }
    }