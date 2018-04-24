package cc.pinyougou.sellergoods.service.impl;



import cc.pinyougou.mapper.TbBrandMapper;
import cc.pinyougou.pojo.TbBrand;
import cc.pinyougou.sellergoods.service.BrandService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by myvisi on 2018/4/23.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;
    @Override
    public List<TbBrand> findAll() {

        return tbBrandMapper.selectByExample(null);
    }
}
