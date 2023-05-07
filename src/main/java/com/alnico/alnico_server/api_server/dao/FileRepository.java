package com.alnico.alnico_server.api_server.dao;

import com.alnico.alnico_server.api_server.domain.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository <UploadedFile,Long> {

    List<UploadedFile> findAllByfileType(String fileType);
}
