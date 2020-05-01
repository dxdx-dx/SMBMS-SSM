package cn.bdqn.smbms.service.impl;

import cn.bdqn.smbms.dao.RoleMapper;
import cn.bdqn.smbms.pojo.Role;
import cn.bdqn.smbms.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色业务逻辑层实现类
 *
 * @author Matrix
 * @date 2020/4/29 1:04
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;//角色dao层对象

    /**
     * 查询所有角色
     */
    @Override
    public List<Role> findAll() {
        List<Role> roleList = new ArrayList<Role>();
        roleList = roleMapper.findAll();
        return roleList;
    }
}
