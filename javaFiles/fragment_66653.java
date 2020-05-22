assertThat(logsFromWaze, hasItem(
        allOf(
                hasProperty("foo", is("bar")),
                hasProperty("name", is("bar"))
        )
));