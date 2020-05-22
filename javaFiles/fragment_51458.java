Map<String,LibVersion> originalVersions = originals.collectEntries {
  LibVersion.fromFilename( it ).with { v ->
    [ (v.library):v ]
  }
}

Map<String,LibVersion> replacementVersions = replacements.collectEntries {
  LibVersion.fromFilename( it ).with { v ->
    [ (v.library):v ]
  }
}