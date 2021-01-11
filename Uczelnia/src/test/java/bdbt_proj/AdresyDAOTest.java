package bdbt_proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class AdresyDAOTest {

	private AdresyDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
		datasource.setUsername("SYSTEM");
		datasource.setPassword("mA4YBUw!!!");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new AdresyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Adresy> listAdresy = dao.list();
//		assertTrue(listAdresy.isEmpty());
		assertFalse(listAdresy.isEmpty());
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
