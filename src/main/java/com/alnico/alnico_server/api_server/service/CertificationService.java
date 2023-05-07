package com.alnico.alnico_server.api_server.service;

import com.alnico.alnico_server.api_server.dao.FileRepository;
import com.alnico.alnico_server.api_server.domain.UploadedFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificationService {

      private final FileRepository fileRepository;

      public List<UploadedFile> get(){
            List<UploadedFile> certifications = fileRepository.findAllByfileType("certification");
            return certifications;
      }

      public void delete(Long id){
            fileRepository.deleteById(id);
      }

      public void post(String name, String fileUrl){
            UploadedFile uploadedFile =new UploadedFile();
            uploadedFile.setFileUrl(fileUrl);
            uploadedFile.setName(name);
            uploadedFile.setFileType("certification");
            fileRepository.save(uploadedFile);
      }

}
