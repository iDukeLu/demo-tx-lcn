package com.idukelu.demo.demotxlcnbanka.business.service;

import com.idukelu.demo.demotxlcnbanka.business.pojo.bo.Result;
import com.idukelu.demo.demotxlcnbanka.business.pojo.dto.TransferDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "TX-LCN-BANKB", fallback = TransferServiceFallback.class)
public interface TransferService {

    @PutMapping("/bankb/transfer")
    ResponseEntity<Result> transfer(@RequestBody TransferDTO account);
}

class TransferServiceFallback implements TransferService {

    public static final Logger logger = LogManager.getLogger(TransferService.class);

    public ResponseEntity<Result> transfer(TransferDTO account) {

        return ResponseEntity.ok(Result.failure("网络异常"));
    }
}
