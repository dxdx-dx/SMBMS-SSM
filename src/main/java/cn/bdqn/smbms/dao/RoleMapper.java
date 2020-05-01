package cn.bdqn.smbms.dao;

import cn.bdqn.smbms.pojo.Role;

import java.util.List;

/**
 * 角色数据访问层
 *
 * @author Matrix
 * @date 2020/4/29 1:03
 */
public interface RoleMapper {
    //查询所有角色列表
    List<Role> findAll();
}
