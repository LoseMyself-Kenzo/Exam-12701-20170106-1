package cn.ssm.service;

public interface LanguageService {
	
	int getLanguageId(String name)throws Exception;
	
	String getLanguageName(int id)throws Exception;
	
}	
