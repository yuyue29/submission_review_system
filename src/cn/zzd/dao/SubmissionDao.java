package cn.zzd.dao;

import cn.zzd.domain.Submission;

import java.util.List;


public interface SubmissionDao {
	public Submission save(Submission submission);
	public Submission delete(Submission submission);
	public List<Submission> findAll();
	public List<Submission> findBy(String type, String value);
}
