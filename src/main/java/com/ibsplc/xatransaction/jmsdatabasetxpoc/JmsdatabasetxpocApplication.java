package com.ibsplc.xatransaction.jmsdatabasetxpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("applicationContext.xml")
public class JmsdatabasetxpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsdatabasetxpocApplication.class, args);
	}

}
