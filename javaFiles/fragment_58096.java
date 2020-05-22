package com.elegant.amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.amazonaws.services.s3.model.Bucket;

public class AmazonS3Test {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws InterruptedException {
        boolean yes = true;
        do {
            System.out.println("\n\n");
            System.out.println("----------AMAZON-----------------------S3-------------------------TEST------------");
            System.out.println("                              1 Get Buckets List");
            System.out.println("                              2 Get First Prefix Of Bucket");
            System.out.println("                              3 Get Next Prefix");
            System.out.println("                              4 Exit");
            System.out.println("----------AMAZON-----------------------S3-------------------------TEST------------");
            System.out.println("\n\n");
            int choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
            case 1:
                List<Bucket> buckets = AmazonS3Util.bucketList;
                for (Bucket bucket : buckets) {
                    System.out.println(bucket.getName());
                }
                break;

            case 2:
                System.out.println("Enter Bucket Name");
                String bucketName = (new Scanner(System.in)).nextLine();
                HashMap<String, List<String>> prefixName = AmazonS3Util.getPrefix(bucketName);
                if (prefixName.containsKey(AWSCommonConstants.GET_FOLDER)) {
                    List<String> prefixList = prefixName.get(AWSCommonConstants.GET_FOLDER);
                    for (String prefix : prefixList) {
                        System.out.println(prefix);
                    }
                }
                if (prefixName.containsKey(AWSCommonConstants.GET_DATA)) {
                    List<String> dataList = prefixName.get(AWSCommonConstants.GET_DATA);
                    for (String data : dataList) {
                        System.out.println(data);
                    }
                }
                break;

            case 3:
                System.out.println("Enter Bucket Name");
                String bucketName1 = (new Scanner(System.in)).nextLine();
                System.out.println("Enter Prefix Name");
                String prefix1 = (new Scanner(System.in)).nextLine();
                HashMap<String, List<String>> prefixName1 = AmazonS3Util.getPrefix(bucketName1, prefix1);
                if (prefixName1.containsKey(AWSCommonConstants.GET_FOLDER)) {
                    List<String> prefixList = prefixName1.get(AWSCommonConstants.GET_FOLDER);
                    for (String prefix : prefixList) {
                        System.out.println(prefix);
                    }
                }
                if (prefixName1.containsKey(AWSCommonConstants.GET_DATA)) {
                    List<String> dataList = prefixName1.get(AWSCommonConstants.GET_DATA);
                    for (String data : dataList) {
                        System.out.println(data);
                    }
                }
                break;

            case 4:
                yes = false;
                break;

            default:
                break;
            }
        } while (yes);
    }
}