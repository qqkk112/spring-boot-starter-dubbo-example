package ${basePackage}.web;
import ${basePackage}.core.Wrapper;
import ${basePackage}.core.WrapMapper;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Wrapper add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return WrapMapper.genSuccessResult();
    }

    @PostMapping("/delete")
    public Wrapper delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return WrapMapper.genSuccessResult();
    }

    @PostMapping("/update")
    public Wrapper update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return WrapMapper.genSuccessResult();
    }

    @PostMapping("/detail")
    public Wrapper detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return WrapMapper.genSuccessResult(${modelNameLowerCamel});
    }

    @PostMapping("/list")
    public Wrapper list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return WrapMapper.genSuccessResult(pageInfo);
    }
}
