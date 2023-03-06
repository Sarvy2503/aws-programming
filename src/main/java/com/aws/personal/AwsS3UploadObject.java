package com.aws.personal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.File;

public class AwsS3UploadObject {

    public static void uploadObject(AmazonS3 s3Client, String bucketName, String key, String filePath)
    {
        PutObjectResult result = s3Client.putObject(bucketName, key, new File(filePath));
        System.out.println("Object uploaded successfully : "+result.getContentMd5());
    }
}
