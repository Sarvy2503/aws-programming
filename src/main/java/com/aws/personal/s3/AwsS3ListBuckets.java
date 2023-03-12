package com.aws.personal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class AwsS3ListBuckets {

    public static void listBucket(AmazonS3 s3Client)
    {
        List<Bucket> buckets = s3Client.listBuckets();

        for(Bucket bucket : buckets){
            System.out.println(bucket.getName());
        }
    }
}
