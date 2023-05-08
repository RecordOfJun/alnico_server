package com.alnico.alnico_server.api_server.api;

import com.alnico.alnico_server.api_server.domain.UploadedFile;
import com.alnico.alnico_server.api_server.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HistoryApi {

    private final HistoryService historyService;

    @GetMapping("/api/history")
    public List<UploadedFile> getCertifications(){

        return historyService.get();
    }

    @DeleteMapping("api/history/{id}")
    public void deleteCertification(@PathVariable("id") Long id){
        historyService.delete(id);
    }

    @PostMapping("api/history")
    public void saveCertification(@RequestParam("name") String name,@RequestParam("file") MultipartFile file) throws Exception{
        historyService.post(name,file);
    }
}
