package com.alnico.alnico_server.api_server.service;

import com.alnico.alnico_server.api_server.dao.FileRepository;
import com.alnico.alnico_server.api_server.domain.UploadedFile;
import com.alnico.alnico_server.api_server.modules.aws.S3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final FileRepository fileRepository;
    private final S3 s3;
    public List<UploadedFile> get(){
        List<UploadedFile> certifications = fileRepository.findAllByfileType("history");
        return certifications;
    }

    public void delete(Long id){
        fileRepository.deleteById(id);
    }

    public void post(String name, MultipartFile file) throws IOException{
        UploadedFile uploadedFile =new UploadedFile();
        uploadedFile.setFileUrl(s3.uploadS3AndGetUrl(file));
        uploadedFile.setName(name);
        uploadedFile.setFileType("history");
        fileRepository.save(uploadedFile);
    }
}
