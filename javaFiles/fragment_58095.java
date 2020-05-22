package com.elegant.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/**
 * A utility class for Amazon S3 Service. It has common methods init. which is
 * used for all common purpose. Amazon S3 client is initialized when class is
 * deployed on the server. for the connection I have used BasicAWSCredentials
 * Class. It sets all the necessary information for accessing Amazon S3 Service
 * like Access Key and Secret Key. It will load all buckets information when
 * it's deployed on the server.
 * 
 * @author Vipin Suman
 * 
 * @since May 5th,2017
 */

@SuppressWarnings("deprecation")
public class AmazonS3Util {

    public static AmazonS3 s3Client = null;

    public static List<Bucket> bucketList = null;

    static {

        try {
            /** Setting Up AWS Credentials For accessing Amazon S3 */
            BasicAWSCredentials awsCredentials = new BasicAWSCredentials(AWSCommonConstants.ACCESS_KEY,
                    AWSCommonConstants.SECRET_KEY);

            /** initializing AmazonS3 Client */
            s3Client = new AmazonS3Client(awsCredentials);

            /** initializing all buckets stored inside Amazon S3 */
            bucketList = s3Client.listBuckets();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns List<Bucket> object. It has informations of all buckets. It
     * stores information of all bucket when class is deployed on the server.
     */
    public static List<Bucket> getAllBuckets() {
        return bucketList;
    }

    /**
     * Returns HashMap object for which has prefixList and dataList init. in
     * this method we are getting all common prefixes list and data list for the
     * given bucket.
     * 
     * This method is called when we are giving only bucketName as Parameter.
     * 
     * @param bucketName
     * 
     */
    public static HashMap<String, List<String>> getPrefix(String bucketName) {
        Long startTime = System.currentTimeMillis();
        ListObjectsRequest listObjectsRequest = null;
        ObjectListing objectListing = null;
        HashMap<String, List<String>> prefixData = null;
        try {
            listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName).withDelimiter(AWSCommonConstants.FILE_DELIMITER);
            prefixData = prepareDataMap(listObjectsRequest, objectListing);
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Total Time Taken : " + (System.currentTimeMillis() - startTime));
        return prefixData;
    }

    /**
     * Returns HashMap object for which has prefixList and dataList init. in
     * this method we are getting all common prefixes list and data list for the
     * given bucket.
     * 
     * This method is called when we give only bucketName and prefix as
     * Parameter.
     * 
     * @param bucketName
     * 
     * @param prefix
     */
    public static HashMap<String, List<String>> getPrefix(String bucketName, String prefix) {
        Long startTime = System.currentTimeMillis();
        ListObjectsRequest listObjectsRequest = null;
        ObjectListing objectListing = null;
        HashMap<String, List<String>> prefixData = null;
        try {
            if (!prefix.endsWith(AWSCommonConstants.FILE_DELIMITER)) {
                prefix += AWSCommonConstants.FILE_DELIMITER;
            }
            listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName).withPrefix(prefix).withDelimiter(AWSCommonConstants.FILE_DELIMITER);
            prefixData = prepareDataMap(listObjectsRequest, objectListing);
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Total Time Taken : " + (System.currentTimeMillis() - startTime));
        return prefixData;
    }

    /**
     * Returns HashMap object. It prepares the HashMap object for the above
     * methods. It's common methods for getPrefix() methods.
     * 
     * @param ListObjectsRequest
     * 
     * @param ObjectListing
     */

    private static HashMap<String, List<String>> prepareDataMap(ListObjectsRequest listObjectsRequest,
            ObjectListing objectListing) {
        HashMap<String, List<String>> prefixData = null;
        try {
            prefixData = new HashMap<String, List<String>>();
            objectListing = s3Client.listObjects(listObjectsRequest);
            List<String> commonPrefixes = objectListing.getCommonPrefixes();
            if (commonPrefixes != null && commonPrefixes.size() != 0) {
                prefixData.put(AWSCommonConstants.GET_FOLDER, commonPrefixes);
            }
            List<S3ObjectSummary> s3KeyList = new ArrayList<S3ObjectSummary>();
            s3KeyList.addAll(objectListing.getObjectSummaries());
            while (objectListing.isTruncated()) {
                objectListing = s3Client.listNextBatchOfObjects(objectListing);
                s3KeyList.addAll(objectListing.getObjectSummaries());
            }
            if (s3KeyList != null && s3KeyList.size() != 0) {
                List<String> objectData = new ArrayList<String>();
                for (S3ObjectSummary s3ObjectSummary : s3KeyList) {
                    objectData.add(s3ObjectSummary.getKey());
                }
                prefixData.put(AWSCommonConstants.GET_DATA, objectData);
            }
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prefixData;
    }
}