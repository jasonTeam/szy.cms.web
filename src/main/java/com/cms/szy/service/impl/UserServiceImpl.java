package com.cms.szy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.szy.entity.po.User;
import com.cms.szy.repository.dao.UserRepositoryDao;
import com.cms.szy.service.UserService;
import com.cms.szy.tools.exception.ImplException;

/**
 * 
 *(用户业务层接口实现类) 
 * @ClassName UserServiceImpl 
 * @author ShenZiYang 
 * @date 2018年1月6日 上午9:38:03
 */

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepositoryDao userRepositoryDao;
	
	@Override
	public List<String> getPermsByUser(Long userId) {
		
		List<String> listPerms = userRepositoryDao.getPermsByUser(userId);
		
		return listPerms;
	}

	
	@Override
	public List<Long> queryAllMenuId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int updatePwd(Long userId, String oriPassword, String newPassword) {
       
        User user = userRepositoryDao.findOne(userId);
        if(!user.getPassword().equals(oriPassword)){
        	throw new ImplException("1111", "原密码错误!");
        }
        int res = userRepositoryDao.updatePwd(newPassword, userId);
        
        return res;
	}
	
	
	
	
}
