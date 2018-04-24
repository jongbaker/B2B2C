package cc.pinyougu.manager.controller;

import cc.pinyougou.pojo.TbBrand;
import cc.pinyougou.sellergoods.service.BrandService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by myvisi on 2018/4/23.
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;//引入dubbo的接口服务对象

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }


}
