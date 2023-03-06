package com.aws.personal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

public class AwsS3CreateNewBucket {

    public static void createNewBucket(AmazonS3 s3Client, String bucketName)
    {
        Bucket newBucket = s3Client.createBucket(bucketName);
        System.out.println("Bucket created successfully : "+newBucket.getName());
    }


}
