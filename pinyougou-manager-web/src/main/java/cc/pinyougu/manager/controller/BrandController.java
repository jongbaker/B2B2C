package cc.pinyougu.manager.controller;

import cc.pinyougou.entity.PageResult;
import cc.pinyougou.entity.Result;
import cc.pinyougou.pojo.TbBrand;
import cc.pinyougou.sellergoods.service.BrandService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.container.page.PageHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/findPage")
    public PageResult findPage(int page,int rows){
        return  brandService.findPage(page,rows);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand ){


        Result result = new Result();

        try {
            int add = brandService.add(tbBrand);
            result.setSuccess(true);
            result.setMessage("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("新增失败");
        }


        return result;
    }

    @RequestMapping("/findOne")
    public  TbBrand findOne(Long id){
        TbBrand tbBrand = brandService.findOne(id);
        return  tbBrand;
    }

    @RequestMapping("/update")
    public  Result update(@RequestBody TbBrand tbBrand){

        Result result = new Result();

        try {
             brandService.update(tbBrand);
            result.setSuccess(true);
            result.setMessage("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("修改失败");
        }


        return result;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        //接收进来就是
        Result result = new Result();

        try {
            brandService.delete(ids);
            result.setSuccess(true);
            result.setMessage("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");
        }


        return result;
    }

    @RequestMapping("/search")
    public  PageResult search(@RequestBody TbBrand tbBrand,int page,int rows){
        PageResult pages = brandService.findPage(tbBrand, page, rows);
        return  pages;//// TODO: 2018/4/25
    }
}
