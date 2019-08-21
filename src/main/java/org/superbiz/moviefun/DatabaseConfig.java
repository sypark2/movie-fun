package org.superbiz.moviefun;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.xml.crypto.Data;

public class DatabaseConfig {

    @Bean
    DatabaseServiceCredentials serviceCredentials(@Value("${vcap.services}")
                                                        String vcapServices){
        return new DatabaseServiceCredentials(vcapServices);
    }

    @Bean
    HibernateJpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }
}
