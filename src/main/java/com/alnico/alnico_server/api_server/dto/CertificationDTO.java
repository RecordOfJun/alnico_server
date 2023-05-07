package com.alnico.alnico_server.api_server.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertificationDTO {
    private String name;
    private String imgURL;

    public String getName() {
        return name;
    }

    public String getImgURL() {
        return imgURL;
    }
}
