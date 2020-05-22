final ClassFile  classFile = ...;
final ConstPool  constPool = classFile.getConstPool();
final MethodInfo minfo     = new MethodInfo( ... );
final Bytecode   code      = new Bytecode( constPool );
... code that writes to 'code'

final List<MyLineNum> lineNums = new ArrayList<>();
... code that adds to 'lineNums'

final CodeAttribute codeAttr = code.toCodeAttribute();
if ( !lineNums.isEmpty() ) {
    // JVM spec describes method line number table thus:
    //    u2 line_number_table_length;
    //    { u2 start_pc;
    //      u2 line_number;
    //    } line_number_table[ line_number_table_length ];
    final int    numLineNums = lineNums.size();
    final byte[] lineNumTbl  = new byte[ ( numLineNums * 4 ) + 2 ];

    // Write line_number_table_length.
    int byteIx = 0;
    ByteArray.write16bit( numLineNums, lineNumTbl, byteIx );
    byteIx += 2;

    // Write the individual line number entries.
    for ( final MyLineNum ln : lineNums) {
        // start_pc
        ByteArray.write16bit( ln.pc, lineNumTbl, byteIx );
        byteIx += 2;
        // line_number
        ByteArray.write16bit( ln.lineNum, lineNumTbl, byteIx );
        byteIx += 2;
    }

    // Add the line number table to the CodeAttribute.
    @SuppressWarnings("unchecked")
    final List<AttributeInfo> codeAttrAttrs = codeAttr.getAttributes();
    codeAttrAttrs.removeIf( ( ai ) -> ai.getName().equals( "LineNumberTable" ) );       // remove if already present
    codeAttrAttrs.add( new AttributeInfo( constPool, "LineNumberTable", lineNumTbl ) );
}

// Attach the CodeAttribute to the MethodInfo.
minfo.setCodeAttribute( codeAttr );

// Attach the MethodInfo to the ClassFile.
try {
    classFile.addMethod( minfo );
}
catch ( final DuplicateMemberException ex ) {
    throw new AssertionError( "Caught " + ex, ex );
}