package com.cms.szy.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.szy.entity.po.Role;
import com.cms.szy.entity.vo.RoleVO;
import com.cms.szy.service.RoleService;
import com.cms.szy.tools.result.Ret;

/**
 * 
 * (角色管理) 
 * @ClassName RoleController 
 * @author ShenZiYang 
 * @date 2018年1月11日 下午4:36:28
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	//分页查询角色列表
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@RequiresPermissions("sys:role:list")
	public Ret roleList(RoleVO vo){
		Page<Role> pageData = roleService.findPageRole(vo, vo.getPageNo()-1, vo.getPageSize(), "roleId");
		return Ret.ok().put("page", pageData);
	}
	
	
}
