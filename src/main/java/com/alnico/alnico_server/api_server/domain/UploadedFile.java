package com.alnico.alnico_server.api_server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UploadedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private String name;
    @Column(columnDefinition = "TEXT")
    private String fileUrl;

    private String fileType;

    @PrePersist
    public void createdAt(){
        this.createdAt=LocalDateTime.now();
    }
}