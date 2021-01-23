package bdbt_proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class PocztyDAOTest {

	private PocztyDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
		datasource.setUsername("SYSTEM");
		datasource.setPassword("mA4YBUw!!!");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new PocztyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Poczty> listPoczty = dao.list();
		assertFalse(listPoczty.isEmpty());
	}

	@Test
	void testSave() {
		Poczty poczty = new Poczty(12, "Nowy S¹cz", "33-300");
		dao.save(poczty);
	}

	@Test
	void testGet() {
		int nr_poczty = 12;
		Poczty poczty = dao.get(nr_poczty);
		
		assertNotNull(poczty);
	}

	@Test
	void testUpdate() {
		Poczty poczty = new Poczty();
		poczty.setNr_poczty(12);
		poczty.setPoczta("Wroc³aw");
		poczty.setKod_poczty("50-027");
		
		dao.update(poczty);
	}

	@Test
	void testDelete() {
		int nr_poczty = 12;
		dao.delete(nr_poczty);
	}

}
