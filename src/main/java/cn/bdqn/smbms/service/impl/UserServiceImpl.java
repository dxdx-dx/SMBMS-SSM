package cn.bdqn.smbms.service.impl;

import cn.bdqn.smbms.dao.UserMapper;
import cn.bdqn.smbms.pojo.User;
import cn.bdqn.smbms.service.UserService;
import cn.bdqn.smbms.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务逻辑层实现类
 *
 * @author Matrix
 * @date 2020/4/28 20:54
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;//用户dao层对象

    /**
     * 登陆
     *
     * @param userCode 用户编码
     * @param password 用户密码
     * @return 用户对象
     */
    @Override
    public User login(String userCode, String password) {
        User user = null;
        try {
            List<User> userList = userMapper.findByUserCode(userCode);
            if (userList == null || userList.size() == 0) {
                return null;
            }
            user = userList.get(0);
            if (user.getUserPassword().equals(password)) {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 分页显示用户列表
     *
     * @param userName 用户名
     * @param userRole 用户角色
     * @param pageNo   当前页
     * @param pageSize 页大小
     * @return 用户集合
     */
    @Override
    public List<User> findByPage(String userName, Integer userRole, Integer pageNo, Integer pageSize) {
        List<User> userList = null;
        userList = userMapper.findByPage(userName, userRole, (pageNo - 1) * Constants.PAGE_SIZE, pageSize);
        return userList;
    }

    /**
     * 查询用户记录数
     *
     * @param userName 用户名
     * @param userRole 用户角色
     * @return 记录数
     */
    @Override
    public int findByPageCount(String userName, Integer userRole) {
        int result = 0;
        result = userMapper.findByPageCount(userName, userRole);
        return result;
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 添加状态
     */
    @Override
    public boolean adduser(User user) {
        boolean result = false;
        int res = 0;
        res = userMapper.adduser(user);
        if (res > 0) result = true;
        return result;
    }

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户对象
     */
    @Override
    public User findUserById(Integer id) {
        User user = null;
        user = userMapper.findUserById(id);
        return user;
    }

    /**
     * 修改用户
     *
     * @return 跳转页面
     */
    @Override
    public boolean modifyUser(User user) {
        boolean result = false;
        int res = 0;
        res = userMapper.modifyUser(user);
        if (res > 0) result = true;
        return result;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 删除结果
     */
    @Override
    public boolean deluser(Integer id) {
        boolean result = false;
        int res = 0;
        res = userMapper.deluser(id);
        if (res > 0) result = true;
        return result;
    }

    /**
     * 根据用户编码查询用户
     *
     * @param userCode 用户编码
     * @author Matrix
     * @date 2020/4/24 9:15
     */
    @Override
    public User findByUserCode(String userCode) {
        User user = null;
        List<User> userList = userMapper.findByUserCode(userCode);
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
            return user;
        } else {
            return null;
        }
    }

    /**
     * 根据id判断旧密码
     *
     * @return boolean
     * @author Matrix
     * @date 2020/4/27 12:57
     */
    @Override
    public boolean validatePwd(Integer id, String oldPwd) {
        boolean flag = false;
        User user = userMapper.findUserById(id);
        if (user != null) {
            if (user.getUserPassword().equals(oldPwd)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 根据id修改密码
     *
     * @return boolean
     * @author Matrix
     * @date 2020/4/27 13:01
     */
    @Override
    public boolean pwdmodifysave(Integer id, String newPwd) {
        boolean result = false;
        int res = 0;
        res = userMapper.modifyPwd(id, newPwd);
        if (res > 0) result = true;
        return result;
    }
}
