package com.infotech.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.infotech.entity")
@ComponentScan(basePackages="com.infotech")
@EnableCassandraRepositories("com.infotech.cassRepo")
@EnableJpaRepositories("com.infotech.jpaRepo")
@Configuration
@EnableAutoConfiguration//(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class ComboParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComboParentApplication.class, args);
	}
}
