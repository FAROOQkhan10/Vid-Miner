package com.farooq.vid_miner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class VidMinerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VidMinerApplication.class, args);
	}

}
