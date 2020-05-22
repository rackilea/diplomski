package com.github.jknack.handlebars;

public class IfBlockTest extends AbstractTest {

@Test
public void falsy() throws IOException {
    // empty string
    shouldCompileTo("{{#if value}}true{{else}}false{{/if}}", $("value", ""), "false");