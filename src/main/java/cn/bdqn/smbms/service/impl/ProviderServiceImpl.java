package cn.bdqn.smbms.service.impl;

import cn.bdqn.smbms.dao.ProviderMapper;
import cn.bdqn.smbms.pojo.Provider;
import cn.bdqn.smbms.service.ProviderService;
import cn.bdqn.smbms.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 供应商业务逻辑层实现类
 */
@Service
public class ProviderServiceImpl implements ProviderService {
    @Resource
    private ProviderMapper providerMapper; //供应商dao层对象

    /**
     * 分页查询供应商列表
     */
    @Override
    public List<Provider> findByPage(String proCode, String proName, Integer pageNo, Integer pageSize) {
        List<Provider> providerList = null;
        providerList = providerMapper.findByPage(proCode, proName, (pageNo - 1) * Constants.PAGE_SIZE, pageSize);
        return providerList;
    }

    /**
     * 查询供应商总条数
     */
    @Override
    public int findByPageCount(String proCode, String proName) {

        int result = 0;
        result = providerMapper.findByPageCount(proCode, proName);

        return result;
    }

    @Override
    public List<Provider> findName() {

        List<Provider> providerList = null;
        providerList = providerMapper.findName();
        return providerList;
    }

    /**
     * 添加供应商
     *
     * @return boolean
     * @author Matrix
     * @date 2020/4/16 20:12
     */
    @Override
    public boolean addPrivider(Provider provider) {
        boolean result = false;
        int res = 0;

        res = providerMapper.addPrivider(provider);
        if (res > 0) result = true;

        return result;
    }

    /**
     * 根据id查询供应商
     *
     * @return cn.bdqn.smbms.pojo.Provider
     * @author Matrix
     * @date 2020/4/26 23:11
     */
    @Override
    public Provider findProviderById(Integer id) {
        Provider provider = null;
        provider = providerMapper.findProviderById(id);
        return provider;
    }

    /**
     * 修改供应商
     *
     * @return boolean
     * @author Matrix
     * @date 2020/4/26 23:11
     */
    @Override
    public boolean providerModify(Provider provider) {
        boolean result = false;
        int res = 0;
        res = providerMapper.providerModify(provider);
        if (res > 0) result = true;
        return result;
    }

    /**
     * 删除供应商
     *
     * @return boolean
     * @author Matrix
     * @date 2020/4/26 23:42
     */
    @Override
    public boolean delprovider(Integer id) {
        boolean result = false;
        int res = 0;
        res = providerMapper.delprovider(id);
        if (res > 0) result = true;
        return result;
    }
}
