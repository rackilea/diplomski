package com.ctg.jooqgenerator.jooq

import org.jooq.codegen.JavaGenerator
import org.jooq.codegen.JavaWriter
import org.jooq.meta.Database
import org.jooq.meta.SchemaDefinition
import org.jooq.meta.TableDefinition
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.sql.ResultSet

class EnumGenerator extends JavaGenerator {
    private static final String ENUMS_SCHEMA = "enums"

    private static final Logger log = LoggerFactory.getLogger(EnumGenerator.class)

    @Override
    void generateSchema(SchemaDefinition schema) {
        // Apply custom logic only for `enums` schema. Others schema has regular generation
        if (schema.name != ENUMS_SCHEMA) {
            super.generateSchema(schema)
            return
        }

        log.info("Generating enums")
        log.info("----------------------------------------------------------")

        Database db = schema.database

        db.getTables(schema).each { TableDefinition table ->
            // Prepare enum name from snake_case to CamelCase
            String enumName = table.name.replaceAll('_([a-z])') { it[1].capitalize() }.capitalize()

            JavaWriter out = newJavaWriter(new File(getFile(schema).getParentFile(), "${enumName}.java"))
            log.info("Generating enum: {}.java [input={}, output={}]", enumName, table.name, enumName)

            printPackage(out, schema)

            out.println("public enum $enumName {")

            ResultSet rs = db.connection.prepareStatement("SELECT * FROM ${schema}.\"${table.name}\"").executeQuery()
            while (rs.next()) {
                String name = rs.getString('name'),
                       description = rs.getString('description'),
                       s = rs.isLast() ? ";" : ","

                // Generate enum entry
                out.tab(1).println("$name(\"$description\")$s")
            }

            out.println("""
            |    private final String description;
            |
            |    private $enumName(String description) {
            |        this.description = description;
            |    }
            |}
            """.stripMargin())

            closeJavaWriter(out)
        }

        log.info("----------------------------------------------------------")
        super.generateSchema(schema)
    }
}