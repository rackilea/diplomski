@Override
public void doXContent(XContentBuilder builder, Params params) throws IOException {
    builder.startObject(MatchAllQueryParser.NAME);
    if (boost != -1) {
        builder.field("boost", boost);
    }
    if (normsField != null) {
        builder.field("norms_field", normsField);
    }
    builder.endObject();
}