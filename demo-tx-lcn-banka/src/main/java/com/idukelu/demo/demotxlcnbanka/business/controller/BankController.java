package com.idukelu.demo.demotxlcnbanka.business.controller;

import com.idukelu.demo.demotxlcnbanka.business.pojo.bo.Result;
import com.idukelu.demo.demotxlcnbanka.business.pojo.dto.TransferDTO;
import com.idukelu.demo.demotxlcnbanka.business.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/banka", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BankController {

    private BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{user}")
    public ResponseEntity<Result> findAccount(@PathVariable String user) {
        return bankService.findAccount(user);
    }

    @PutMapping("/transfer")
    public ResponseEntity<Result> Transfer(@RequestBody TransferDTO transfer) {
        return bankService.transfer(transfer);
    }

}
