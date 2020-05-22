assertThat(
    categorizedFuaDto.getMetainfos(), hasItems(Matchers.<YourClass>
        hasProperty("key", equalTo(receivedMetaInfoValue.getKey())),
        hasProperty("value", equalTo(receivedMetaInfoValue.getValue()))
    )
);