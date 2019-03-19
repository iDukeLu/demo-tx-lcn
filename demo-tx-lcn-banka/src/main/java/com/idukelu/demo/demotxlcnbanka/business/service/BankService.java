package com.idukelu.demo.demotxlcnbanka.business.service;

import com.idukelu.demo.demotxlcnbanka.business.pojo.bo.Result;
import com.idukelu.demo.demotxlcnbanka.business.pojo.dto.TransferDTO;
import org.springframework.http.ResponseEntity;

public interface BankService {

    ResponseEntity<Result> findAccount(String user);

    ResponseEntity<Result> transfer(TransferDTO account);

}
