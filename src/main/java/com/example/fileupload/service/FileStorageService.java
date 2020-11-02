package com.example.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileStorageService {

    public static String TYPE = "application/json";
    
    public String storeFile(MultipartFile file) {
    	// Check the file format
        if(!TYPE.equals(file.getContentType())) {
            throw new FileStorageException("Sorry! file format not valid");
        }
        
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // Check if the file's name contains invalid characters
        if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
        
            return fileName;
    }
}
