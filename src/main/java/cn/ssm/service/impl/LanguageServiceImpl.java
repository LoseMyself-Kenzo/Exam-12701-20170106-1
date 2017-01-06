package cn.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ssm.mapper.LanguageMapper;
import cn.ssm.service.LanguageService;

public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageMapper languageMapper;

	@Override
	public int getLanguageId(String name) throws Exception {

		return languageMapper.getLanguageId(name);

	}

	@Override
	public String getLanguageName(int id) throws Exception {

		return languageMapper.getLanguageName(id);
	}

}
