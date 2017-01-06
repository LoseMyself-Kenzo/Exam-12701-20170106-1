package cn.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ssm.mapper.CustomerMapper;
import cn.ssm.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public String findCustomerByName(String first_name) throws Exception {
		// TODO Auto-generated method stub
		String a = null;
		a = customerMapper.findCustomerByName(first_name);
		if (a != null) {
			return a;
		} else
			return a;
	}
}
