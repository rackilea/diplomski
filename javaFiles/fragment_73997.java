class ParserFactory {

    Parser escapedSequence() {
        return Parsers.between(Scanners.string("["), 
            Scanners.anyCharacterButNot("]"), Scanners.string("]"));
    }

    Parser chunk() {
        return Parsers.or(escapedSequence(), Scanners.anyCharacterButNot("|"));
    }

    Parsers wholeThing() {
        return Parsers.separatedBy(chunk().plus(), Scanners.string("|"));
    }
}