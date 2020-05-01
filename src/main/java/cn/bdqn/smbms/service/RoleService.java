package cn.bdqn.smbms.service;

import cn.bdqn.smbms.pojo.Role;

import java.util.List;

/**
 * 角色业务逻辑层
 *
 * @author Matrix
 * @date 2020/4/29 1:04
 */
public interface RoleService {
    //查询所有角色
    List<Role> findAll();
}
