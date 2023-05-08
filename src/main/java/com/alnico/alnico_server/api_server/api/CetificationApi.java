package com.alnico.alnico_server.api_server.api;

import com.alnico.alnico_server.api_server.domain.UploadedFile;
import com.alnico.alnico_server.api_server.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CetificationApi {
    private final CertificationService certificationService;
    @GetMapping("/api/certification")
    public List<UploadedFile> getCertifications(){

        return certificationService.get();
    }

    @DeleteMapping("api/certification/{id}")
    public void deleteCertification(@PathVariable("id") Long id){
        certificationService.delete(id);
    }

    @PostMapping("api/certification")
    public void saveCertification(@RequestParam("name") String name,@RequestParam("file") MultipartFile file) throws Exception{
        certificationService.post(name,file);
    }
}
