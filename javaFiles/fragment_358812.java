package com.mycompany.amazon.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AmazonCrawler {

    private static final Logger LOG = LogManager.getLogger(AmazonCrawler.class);

    public static void main(String[] args) throws IOException {

        List<Review> reviews = new ArrayList<>();
        int pageNumber = 1;

        while (true) {

            /*
            URL is changed after saving answer, change it to this: 
            https://www.amazon.com/Dell-Inspiron-Touchscreen-Performance-Bluetooth/product-reviews/B01MXLQ5TM/ref=cm_cr_getr_d_paging_btm_ + pageNumber + ?reviewerType=all_reviews&pageNumber= + pageNumber
             */
            String url = "https://www.amazon.com/Dell-Inspiron-Touchscreen-Performance-Bluetooth/product-reviews/B01MXLQ5TM/ref=cm_cr_getr_d_paging_btm_" + pageNumber + "?reviewerType=all_reviews&pageNumber=" + pageNumber;

            LOG.info("Crawling URL: {}", url);

            Document doc = Jsoup.connect(url).get();
            Elements reviewElements = doc.select(".review");
            if (reviewElements == null || reviewElements.isEmpty()) {
                break;
            }

            for (Element reviewElement : reviewElements) {

                Element titleElement = reviewElement.select(".review-title").first();
                if (titleElement == null) {
                    LOG.error("Title element is null");
                    continue;
                }
                String title = titleElement.text();

                Element textElement = reviewElement.select(".review-text").first();
                if (textElement == null) {
                    LOG.error("Text element is null");
                    continue;
                }
                String text = textElement.text();

                reviews.add(new Review(title, text));
            }

            pageNumber++;
        }

        LOG.info("Number of reviews: {}", reviews.size());

        for (Review review : reviews) {
            System.out.println(review.getTitle());
            System.out.println(review.getText());
            System.out.println("\n");
        }
    }

    static class Review {

        private final String title;
        private final String text;

        public Review(String title, String text) {
            this.title = title;
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public String getText() {
            return text;
        }

    }

}