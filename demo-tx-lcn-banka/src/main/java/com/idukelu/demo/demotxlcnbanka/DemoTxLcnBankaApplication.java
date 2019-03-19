package com.idukelu.demo.demotxlcnbanka;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
@EnableDistributedTransaction
public class DemoTxLcnBankaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTxLcnBankaApplication.class, args);
	}

}
