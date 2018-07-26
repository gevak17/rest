package com.gevak.rest.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void processCsvFile(MultipartFile file);

    void save(String departmentCode,
             String departmentName,
             String positionCode,
             String ovtMtzCode,
             String ovtMtzName,
             String rankCode,
             String rankName,
             String amount,
             String unit);

}
