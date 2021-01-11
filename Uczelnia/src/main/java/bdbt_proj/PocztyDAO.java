package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PocztyDAO {

	/* JdbcTemplate */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor for jdbcTemplate */
	public PocztyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List for data from database */
	public List<Poczty> list() {

		String sql = "SELECT * FROM POCZTY ";
		List<Poczty> listPoczty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczty.class));
		return listPoczty;
	}

	/* (C)reate - Insert new record */
	public void save(Poczty poczty) {

	}

	/* (R)ead - read data from database */
	public Poczty get(int nr_poczty) {
		return null;
	}

	/* (U)pdate - data inside database */
	public void update(Poczty poczty) {

	}

	/* (D)elete - choosen data */
	public void delete(int nr_poczty) {

	}
}
