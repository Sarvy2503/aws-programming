package com.aws.personal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AwsS3Client {

    //referene : https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-s3-objects.html

    public static void main(String[] args)
    {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Constants.REGION).build();

        //list buckets
        AwsS3ListBuckets.listBucket(s3Client);

        //create new bucket
        AwsS3CreateNewBucket.createNewBucket(s3Client, "s3-bucket-created-via-program");

        //upload file
        AwsS3UploadObject.uploadObject(s3Client, Constants.BUCKET_NAME, "glue-input", "C:\\Users\\rrami\\OneDrive\\Desktop\\blogs\\aws\\glue-input.txt");

        //download
        AwsDownloadClient.downloadObject(s3Client, Constants.BUCKET_NAME,
                "glue-output-skills-matching-java/run-1678079287030-part-r-00000", "glue-etl_output_skill_matching_java");
    }
}
