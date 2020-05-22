new GlassBuilder(16_OZ).withHandle().withLogo(logo).build()

// instead of
new Glass(16_OZ, 
            /* handle? */ true, 
            /* chipped? */ false, 
            /* monogram? */ null, 
            /* something else? */ null, 
            logo);