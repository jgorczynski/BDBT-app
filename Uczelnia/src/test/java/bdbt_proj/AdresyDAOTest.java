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

		assertFalse(listAdresy.isEmpty());
	}

	@Test
	void testSave() {
		Adresy adresy = new Adresy(8, "Warszawa", "Hirszfelda", "18/79", 2);
		dao.save(adresy);
	}

	@Test
	void testGet() {
		int nr_adresu = 8;
		Adresy adresy = dao.get(nr_adresu);

		assertNotNull(adresy);
	}

	@Test
	void testUpdate() {
		Adresy adresy = new Adresy();
		adresy.setNr_adresu(8);
		adresy.setMiasto("Warszawa");
		adresy.setUlica("Jana Olbrachta");
		adresy.setNr_lokalu("58/21");
		adresy.setNr_poczty(3);

		dao.update(adresy);
	}

	@Test
	void testDelete() {
		int nr_adresu = 8;

		dao.delete(nr_adresu);
	}

}
