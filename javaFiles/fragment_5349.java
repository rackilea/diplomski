class MyTagLib {
    static namespace = "myTags"

    def something = { attrs, body ->
        out << g.formatDate(date: attrs.date, format: 'HH:mm')
    }
}