package com.makersacademy.acebook.restcontroller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Date;

import org.flywaydb.core.internal.resource.classpath.ClassPathResource;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

import javax.servlet.http.HttpServletResponse;


@RestController
    @RequestMapping("/api/upload")
    public class UploadController {

        @Autowired
        private AmazonS3 s3client;

        @Value("${endpointUrl}")
        private String endpointUrl;

        @Value("${bucketName}")
        private String bucketName;


        @PostMapping("/uploadfile")
        public String uploadFile(@RequestPart(value = "file") MultipartFile multipartFile) {

            String fileUrl = "";
            String  status = null;
            try {

                //converting multipart file to file
                File file = convertMultiPartToFile(multipartFile);

                //filename
                String fileName = multipartFile.getOriginalFilename();

                fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;

                status = uploadFileTos3bucket(fileName, file);

                file.delete();

            } catch (Exception e) {

                return "UploadController().uploadFile().Exception : " + e.getMessage();

            }
            return fileUrl;
        }

        private File convertMultiPartToFile(MultipartFile file) throws IOException {
            File convFile = new File(file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
        }


        private String uploadFileTos3bucket(String fileName, File file) {
            try {
              s3client.putObject(new PutObjectRequest(bucketName, fileName, file));
            }catch(AmazonServiceException e) {
                return "uploadFileTos3bucket().Uploading failed :" + e.getMessage();
            }
            return "";
        }

    }



