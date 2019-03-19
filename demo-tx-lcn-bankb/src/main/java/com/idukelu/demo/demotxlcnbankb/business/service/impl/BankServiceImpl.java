package com.idukelu.demo.demotxlcnbankb.business.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.idukelu.demo.demotxlcnbankb.business.dao.BankMapper;
import com.idukelu.demo.demotxlcnbankb.business.pojo.bo.Result;
import com.idukelu.demo.demotxlcnbankb.business.pojo.dto.TransferDTO;
import com.idukelu.demo.demotxlcnbankb.business.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankServiceImpl implements BankService {

    BankMapper bankMapper;

    @Autowired
    public BankServiceImpl(BankMapper bankMapper) {
        this.bankMapper = bankMapper;
    }

    public ResponseEntity<Result> findAccount(String user) {
        return ResponseEntity.ok(Result.success(bankMapper.findAccount(user)));
    }

    @LcnTransaction
    public ResponseEntity<Result> transfer(TransferDTO transfer) {
        Result res = bankMapper.transfer(transfer) > 0
                ? Result.success("转账成功")
                : Result.failure("转账失败");
        return ResponseEntity.ok(res);
    }


}
