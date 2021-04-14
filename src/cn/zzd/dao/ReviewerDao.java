package cn.zzd.dao;

import cn.zzd.domain.Reviewer;

import java.util.List;


public interface ReviewerDao {
	public Reviewer save(Reviewer reviewer);
	public Reviewer delete(Reviewer reviewer);
	public List<Reviewer> findAll();
	public List<Reviewer> findBy(String type, String value);
}
