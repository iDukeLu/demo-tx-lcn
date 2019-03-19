package com.idukelu.demo.demotxlcnbanka.business.dao;

import com.idukelu.demo.demotxlcnbanka.business.pojo.dto.TransferDTO;
import com.idukelu.demo.demotxlcnbanka.business.pojo.po.AccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankMapper {

    AccountDO findAccount(String user);

    int transfer(TransferDTO account);
}
