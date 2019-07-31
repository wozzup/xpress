package com.wuyuncheng.xpress.controller.admin;

import com.wuyuncheng.xpress.model.param.SettingParam;
import com.wuyuncheng.xpress.service.SettingService;
import com.wuyuncheng.xpress.util.MessageResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @ApiOperation("获取设置列表")
    @GetMapping("/settings")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> listSettings() {
        return settingService.listSettings();
    }

    @ApiOperation("更新设置")
    @PutMapping("/settings")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse updateSettings(@Valid SettingParam settingParam) {
        settingService.updateSettings(settingParam);
        return MessageResponse.message("分类更新成功");
    }

}