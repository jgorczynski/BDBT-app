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
public class UczelnieDAO {

	/* JdbcTemplate */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor for jdbcTemplate */
	public UczelnieDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List for data from database */
	public List<Uczelnie> list() {

		String sql = "SELECT * FROM UCZELNIE";
		List<Uczelnie> listUczelnie = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Uczelnie.class));
		return listUczelnie;
	}

	/* (C)reate - Insert new record */
	public void save(Uczelnie uczelnie) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("uczelnie").usingColumns("nr_Uczelnia", "nazwa_U", "data_zalozenia", "mail",
				"telefon", "nr_adresu");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uczelnie);
		insertActor.execute(param);
	}

	/* (R)ead - read data from database */
	public Uczelnie get(int nr_Uczelnia) {
		Object[] args = { nr_Uczelnia };
		String sql = "SELECT * FROM UCZELNIE WHERE nr_Uczelnia = " + args[0];
		Uczelnie uczelnie = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Uczelnie.class));

		return uczelnie;
	}

	/* (U)pdate - data inside database */
	public void update(Uczelnie uczelnie) {
		String sql = "UPDATE UCZELNIE SET nazwa_U=:nazwa_U, data_zalozenia=:data_zalozenia, mail=:mail, telefon=:telefon, nr_adresu=:nr_adresu WHERE nr_Uczelnia=:nr_Uczelnia";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uczelnie);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);
	}

	/* (D)elete - choosen data */
	public void delete(int nr_Uczelnia) {
		String sql = "DELETE FROM UCZELNIE WHERE nr_Uczelnia = ?";
		jdbcTemplate.update(sql, nr_Uczelnia);
	}
}
