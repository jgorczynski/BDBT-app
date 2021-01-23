package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("poczty").usingColumns("nr_poczty", "poczta", "kod_poczty");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczty);
		insertActor.execute(param);
	}

	/* (R)ead - read data from database */
	public Poczty get(int nr_poczty) {
		Object[] args = { nr_poczty };
		String sql = "SELECT * FROM POCZTY WHERE nr_poczty = " + args[0];
		Poczty poczty = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Poczty.class));

		return poczty;
	}

	/* (U)pdate - data inside database */
	public void update(Poczty poczty) {
		String sql = "UPDATE POCZTY SET nr_poczty=:nr_poczty, poczta=:poczta, kod_poczty=:kod_poczty";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczty);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);
	}

	/* (D)elete - choosen data */
	public void delete(int nr_poczty) {
		String sql = "DELETE FROM POCZTY WHERE nr_poczty = ?";
		jdbcTemplate.update(sql, nr_poczty);
	}
}
