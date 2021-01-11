package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdresyDAO {

	/* JdbcTemplate */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor for jdbcTemplate */
	public AdresyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List for data from database */
	public List<Adresy> list() {

		String sql = "SELECT * FROM ADRESY";
		List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
		return listAdresy;
	}

	/* (C)reate - Insert new record */
	public void save(Adresy adresy) {

	}

	/* (R)ead - read data from database */
	public Adresy get(int nr_adresu) {
		return null;
	}

	/* (U)pdate - data inside database */
	public void update(Adresy adresy) {

	}

	/* (D)elete - choosen data */
	public void delete(int nr_adresu) {

	}
}
