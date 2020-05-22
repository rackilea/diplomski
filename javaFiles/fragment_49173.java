package com.mrhaki.spock

import spock.lang.Issue
import spock.lang.Specification

class WordRepositorySpec extends Specification {


    @Remote  // Apply our Remote annotation.
    @Issue(["Issue1", "Issue2"])
    def "test remote access"() {
        given:
        final RemoteAccess access = new RemoteAccess()

        expect:
        access.findWords('S') == ['Spock']
    }

    @Issue("Issue4")
    def "test local access"() {
        given:
        final LocalAccess access = new LocalAccess()

        expect:
        access.findWords('S') == ['Spock']
    }

}