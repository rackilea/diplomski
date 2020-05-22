/**
 * Property for disabling/enabling generation of XML Facets during schemagen.
 * The mapped value must be of type Boolean.
 * If it's true, then facets will be generated, based on the BV annotations.
 * If false, the BV annotations processing will be skipped during schemagen
 * and no facets will be generated.
 *
 * @since 2.6
 */
public static final String GENERATE_FACETS = "eclipselink.generate.facets";