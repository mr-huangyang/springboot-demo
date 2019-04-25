package com.okz.cip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 主程序，程序入口
 */

@SpringBootApplication
@MapperScan(basePackages = {"com.okz.cip.dao"})
public class CipApplication {

	public static void main(String[] args) {
		SpringApplication.run(CipApplication.class, args);
	}

}
