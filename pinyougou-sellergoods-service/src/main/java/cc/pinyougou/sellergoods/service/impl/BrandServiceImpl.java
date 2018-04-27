package cc.pinyougou.sellergoods.service.impl;


import cc.pinyougou.entity.PageResult;
import cc.pinyougou.mapper.TbBrandMapper;
import cc.pinyougou.pojo.TbBrand;
import cc.pinyougou.pojo.TbBrandExample;
import cc.pinyougou.sellergoods.service.BrandService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.provider.ExampleProvider;

import java.util.Arrays;
import java.util.List;

/**
 * Created by myvisi on 2018/4/23.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {

        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());

    }

    @Override
    public int add(TbBrand tbBrand) {

        return tbBrandMapper.insert(tbBrand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void delete(Long[] ids) {

   /*
       失败
    //第二种方式
        List<Long> idds = Arrays.asList(ids);
        TbBrandExample example = new TbBrandExample();
        example.createCriteria().andIdIn(idds);

        tbBrandMapper.deleteByExample(example);

*/

      //第一种方式
      for (Long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        if (tbBrand!=null){
            if (tbBrand.getName()!=null&&tbBrand.getName().length()>0){
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }
            if (tbBrand.getFirstChar()!=null&&tbBrand.getFirstChar().length()>0){
                criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
            }
        }
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(tbBrandExample);
        Page<TbBrand> page = (Page<TbBrand>)tbBrands;
        PageResult pageResult = new PageResult();
        pageResult.setRows(page.getResult());
        pageResult.setTotal(page.getTotal());
        return pageResult;
    }

}
