package cn.ssm.mapper;

public interface LanguageMapper {
	
	int getLanguageId(String name)throws Exception;
	
	String getLanguageName(int id)throws Exception;
}
