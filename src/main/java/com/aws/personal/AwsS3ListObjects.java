package com.aws.personal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AwsS3ListObjects {

    public static void listObjects(AmazonS3 s3Client, String bucketName)
    {
        ListObjectsV2Result result = s3Client.listObjectsV2(bucketName);
        for(S3ObjectSummary summary : result.getObjectSummaries()){
            System.out.println(summary.getKey());
        }
    }
}
