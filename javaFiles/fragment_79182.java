package com.jesperancinha.string;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringReplaceBrTest {


    @Test
    void closeSingleAlreadyClosed() {
        assertThat(StringReplaceBr.closeBrTags("<br/>"))
                .isEqualTo("<br />");
    }

    @Test
    void closeSingleNotClosed() {
        assertThat(StringReplaceBr.closeBrTags("<br>"))
                .isEqualTo("<br />");
    }

    @Test
    void closeSingleMixedNotClosed() {
        assertThat(StringReplaceBr.closeBrTags("<br style=\"\" somethingElse=''>"))
                .isEqualTo("<br style=\"\" somethingElse='' />");
    }

    @Test
    void closeBrTags() {
        assertThat(StringReplaceBr.closeBrTags("<br> text here <br/> text here <br> text here <br style='font-size: 14px;'> <a><a/>"))
                .isEqualTo("<br /> text here <br /> text here <br /> text here <br style='font-size: 14px;' /> <a><a/>");
    }

    @Test
    void closeBrTagsDoubleQuotes() {
        assertThat(StringReplaceBr.closeBrTags("<br> text here <br/> text here <br> text here <br style=\"font-size: 14px;\"> <a><a/>"))
                .isEqualTo("<br /> text here <br /> text here <br /> text here <br style=\"font-size: 14px;\" /> <a><a/>");
    }

    @Test
    void closeBrSmall() {
        assertThat(StringReplaceBr.closeBrTags("<br/> <br> <br/> <a><a/> <br wow=''>"))
                .isEqualTo("<br /> <br /> <br /> <a><a/> <br wow='' />");
    }

}