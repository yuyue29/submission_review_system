package cn.zzd.dao;

import cn.zzd.domain.Contribution;

import java.util.List;


public interface ContributionDao {
	public Contribution save(Contribution contribution);
	public Contribution delete(Contribution contribution);
	public List<Contribution> findAll();
	public List<Contribution> findBy(String type, String value);
	public List<Contribution> findUni(String value1, String value2);
}
