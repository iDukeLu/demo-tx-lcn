package com.idukelu.demo.demotxlcnbankb.business.service;

import com.idukelu.demo.demotxlcnbankb.business.pojo.bo.Result;
import com.idukelu.demo.demotxlcnbankb.business.pojo.dto.TransferDTO;
import org.springframework.http.ResponseEntity;

public interface BankService {

    ResponseEntity<Result> findAccount(String user);

    ResponseEntity<Result> transfer(TransferDTO transfer);

}
