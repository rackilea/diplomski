List<KeyValueStoreModel> filtered = kvlist.stream().filter(
      kv -> shippers.stream().anyMatch(
               s -> s.getCode().equals(kv.getCode())
            )
      )
).collect(Collectors.toList());