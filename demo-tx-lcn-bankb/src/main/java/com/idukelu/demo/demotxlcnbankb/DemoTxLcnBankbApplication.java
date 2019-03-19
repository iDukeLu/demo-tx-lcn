package com.idukelu.demo.demotxlcnbankb;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
@EnableDistributedTransaction
public class DemoTxLcnBankbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTxLcnBankbApplication.class, args);
    }

}
