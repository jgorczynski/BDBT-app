package bdbt_proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class UczelnieDAOTest {

	private UczelnieDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
		datasource.setUsername("SYSTEM");
		datasource.setPassword("mA4YBUw!!!");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new UczelnieDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Uczelnie> listUczelnie = dao.list();
		assertFalse(listUczelnie.isEmpty());
	}

	@Test
	void testSave() {
		Uczelnie uczelnie = new Uczelnie(2, "Uniwersytet Warszawski", "1826/01/01", "centrala@uw.edu.pl", "223582801",
				2);
		dao.save(uczelnie);
	}

	@Test
	void testGet() {
		int nr_Uczelnia = 2;
		Uczelnie uczelnie = dao.get(nr_Uczelnia);
		
		assertNotNull(uczelnie);
	}

	@Test
	void testUpdate() {
		Uczelnie uczelnie = new Uczelnie();
		uczelnie.setNr_Uczelnia(3);
		uczelnie.setNazwa_U("Uniwersytet Jagielloñski");
		uczelnie.setData_zalozenia("1364/01/01");
		uczelnie.setMail("centrala@uj.edu.pl");
		uczelnie.setTelefon("336980778");
		uczelnie.setNr_adresu(8);
		
		dao.update(uczelnie);
	}

	@Test
	void testDelete() {
		int nr_Uczelnia = 2;
		dao.delete(nr_Uczelnia);
	}

}
