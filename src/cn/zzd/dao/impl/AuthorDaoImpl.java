package cn.zzd.dao.impl;

import cn.zzd.dao.AuthorDao;
import cn.zzd.domain.Author;
import cn.zzd.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;


public class AuthorDaoImpl implements AuthorDao {
	private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDs());

	// insert and update
	@Override
    public Author save(Author author) {
		if (findBy("id", author.getId()).size() != 0) {
			String sql = "UPDATE `submission`.`author` t SET t.`account_` = ?, t.`password_` = ?, t.`name_` = ?, t.`contact` = ? WHERE t.`id` LIKE ? ESCAPE '#'";
			template.update(sql,
					author.getAccount_(),
					author.getPassword_(),
					author.getName_(),
					author.getContact(),
					author.getId());
			return author;
		}
		String sql = "INSERT INTO `submission`.`author` (`id`, `account_`, `password_`, `name_`, `contact`) VALUES (?, ?, ?, ?, ?)";
		template.update(sql,
				UUID.randomUUID().toString(),
				author.getAccount_(),
				author.getPassword_(),
				author.getName_(),
				author.getContact());
		return author;
	}

	// delete
	@Override
    public Author delete(Author author) {
		String sql = "DELETE FROM `submission`.`author` WHERE `id` LIKE ? ESCAPE '#'";
		template.update(sql,
				author.getId());
		return author;
	}

	// find
	@Override
	public List<Author> findAll() {
		String sql = "SELECT t.* FROM `submission`.`author` t LIMIT 501";
		List<Author> authors ;
		authors =  template.query(sql,new BeanPropertyRowMapper<Author>(Author.class));

		return authors;
	}

	@Override
    public List<Author> findBy(String type, String value) {
		String sql = "SELECT t.* FROM `submission`.`author` t WHERE `" + type + "` = ? LIMIT 501";
		List<Author> authors;
		authors=template.query(sql,new BeanPropertyRowMapper<Author>(Author.class),value);

		return authors;
	}

}
