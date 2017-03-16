package online.com.collaborative.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"online.com.collaborative"})
@EnableTransactionManagement
public class HibernateConfig {
	private final static String database_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String database_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String database_DIALECT = "org.hibernate.dialect.Oracle10gDialect";
	private final static String database_USERNAME = "nandinis";
	private final static String database_PASSWORD = "krishna";

	// datasource bean will be available
	@Bean("datasource")
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();

		// providing database connection information
		System.out.println("Data source is being called");
		datasource.setDriverClassName(database_DRIVER);
		datasource.setUrl(database_URL);
		datasource.setUsername(database_USERNAME);
		datasource.setPassword(database_PASSWORD);

		return datasource;
	}

	// sessionfactory
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("online.com.collaborative.model");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", database_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	//transactionmanager bean to manage the transactions	
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory)
		{
			HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionfactory);
			return transactionManager;
		}
}
