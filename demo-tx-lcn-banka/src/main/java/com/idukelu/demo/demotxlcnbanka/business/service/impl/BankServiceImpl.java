package com.idukelu.demo.demotxlcnbanka.business.service.impl;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.idukelu.demo.demotxlcnbanka.business.dao.BankMapper;
import com.idukelu.demo.demotxlcnbanka.business.pojo.bo.Result;
import com.idukelu.demo.demotxlcnbanka.business.pojo.dto.TransferDTO;
import com.idukelu.demo.demotxlcnbanka.business.pojo.po.AccountDO;
import com.idukelu.demo.demotxlcnbanka.business.service.BankService;
import com.idukelu.demo.demotxlcnbanka.business.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankServiceImpl implements BankService {

    BankMapper bankMapper;

    TransferService transferService;

    @Autowired
    public BankServiceImpl(BankMapper bankMapper, TransferService transferService) {
        this.bankMapper = bankMapper;
        this.transferService = transferService;
    }

    public ResponseEntity<Result> findAccount(String user) {
        return ResponseEntity.ok(Result.success(bankMapper.findAccount(user)));
    }

    @LcnTransaction
    public ResponseEntity<Result> transfer(TransferDTO transfer) {

        AccountDO account = bankMapper.findAccount(transfer.getUser());
        if (account.getMoney() < transfer.getMoney()) {
            return ResponseEntity.ok(Result.failure("余额不足"));
        }

        if (transferService.transfer(transfer).getBody().getStatus().equals("success")) {
            Result res = bankMapper.transfer(transfer) > 0
                    ? Result.success("转账成功")
                    : Result.failure("转账失败");
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.ok(Result.failure("转账失败"));

    }
}
