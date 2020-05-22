@Test
public void testCardParsing() throws Exception {
    String grammar =
        "grammar Oracle;\n" +
        "\n" +
        "line @init{setErrorHandler(new BailErrorStrategy());} @after {System.out.println($ctx.toStringTree(this));} :\n" +
        "  keywordAbility EOF;\n" +
        "\n" +
        "keywordAbility:\n" +
        "  Enchant singularObject #Enchant |\n" +
        "//  Protection From pluralObject #Protection;                   // (A)\n" +
        "    Protection From (pluralObject | objectQuality) #Protection; // (B)\n" +
        "\n" +
        "singularObject:\n" +
        "  objectQuality? Creature;\n" +
        "\n" +
        "pluralObject:\n" +
        "  objectQuality? Creatures;\n" +
        "\n" +
        "objectQuality:\n" +
        "  cardtypeQuality+? |\n" +
        "  supertypeQuality+ cardtypeQuality*? |\n" +
        "  colorQuality+ supertypeQuality* cardtypeQuality*?;\n" +
        "\n" +
        "colorQuality:\n" +
        "  Black;\n" +
        "\n" +
        "supertypeQuality:\n" +
        "  Legendary;\n" +
        "\n" +
        "cardtypeQuality:\n" +
        "  Creature;\n" +
        "\n" +
        "Black: 'black';\n" +
        "Creature: 'creature';\n" +
        "Creatures: 'creatures';\n" +
        "Enchant: 'enchant';\n" +
        "From: 'from';\n" +
        "Legendary: 'legendary';\n" +
        "Protection: 'protection';\n" +
        "\n" +
        "WS: [ \\t\\f\\r\\n]+ -> skip;";

    String input = "enchant creature";
    String found = execParser("Oracle.g4", grammar, "OracleParser", "OracleLexer", "line", input, true);
    assertEquals("(line (keywordAbility enchant (singularObject creature)) <EOF>)\n", found);
    assertNull(stderrDuringParse);

    input = "enchant black creature";
    found = execParser("Oracle.g4", grammar, "OracleParser", "OracleLexer", "line", input, false);
    assertEquals("(line (keywordAbility enchant (singularObject (objectQuality (colorQuality black)) creature)) <EOF>)\n", found);
    assertNull(stderrDuringParse);

    input = "protection from black";
    found = execParser("Oracle.g4", grammar, "OracleParser", "OracleLexer", "line", input, false);
    assertEquals("(line (keywordAbility protection from (objectQuality (colorQuality black))) <EOF>)\n", found);
    assertNull(stderrDuringParse);

    input = "protection from black creatures";
    found = execParser("Oracle.g4", grammar, "OracleParser", "OracleLexer", "line", input, false);
    assertEquals("(line (keywordAbility protection from (pluralObject (objectQuality (colorQuality black)) creatures)) <EOF>)\n", found);
    assertNull(stderrDuringParse);
}