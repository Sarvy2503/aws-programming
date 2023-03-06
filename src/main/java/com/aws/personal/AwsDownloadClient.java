package com.aws.personal;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AwsDownloadClient {

    public static void downloadObject(AmazonS3 s3Client, String bucketName, String objectName, String output)
    {
        try {
            S3Object object = s3Client.getObject(bucketName, objectName);//s3://razara-s3-bucket-public/glue-output-skills-matching-java/run-1678079287030-part-r-00000
            S3ObjectInputStream s3is = object.getObjectContent();
            FileOutputStream fos = new FileOutputStream(new File(output)); //glue-etl_output_skill_matching_java
            byte[] read_buf = new byte[1024];
            int read_len;
            while ((read_len = s3is.read(read_buf)) > 0) {
                fos.write(read_buf, 0, read_len);
            }
            s3is.close();
            fos.close();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done!");

    }
}
