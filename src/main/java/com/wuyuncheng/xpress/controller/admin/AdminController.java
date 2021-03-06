package com.wuyuncheng.xpress.controller.admin;

import com.wuyuncheng.xpress.model.dto.UserDTO;
import com.wuyuncheng.xpress.model.param.LoginParam;
import com.wuyuncheng.xpress.model.param.UserParam;
import com.wuyuncheng.xpress.model.vo.AuthInfo;
import com.wuyuncheng.xpress.service.AdminService;
import com.wuyuncheng.xpress.model.vo.MessageResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("ApiAdminController")
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("登陆")
    @PostMapping("/token")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthInfo login(@RequestBody @Valid LoginParam loginParam) {
        return adminService.getToken(loginParam);
    }

    @ApiOperation("创建用户")
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse createUser(@RequestBody @Valid UserParam userParam) {
        adminService.createUser(userParam);
        return MessageResponse.message("用户创建成功");
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> listUsers() {
        return adminService.listUsers();
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable Integer id) {
        adminService.removeUser(id);
    }

    @ApiOperation("获取单个用户")
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser(@PathVariable Integer id) {
        return adminService.getUser(id);
    }

    @ApiOperation("获取当前用户")
    @GetMapping("/users/current")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getCurrentUser() {
        return adminService.getCurrentUser();
    }

    @ApiOperation("更新用户")
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse updateUser(@RequestBody @Valid UserParam userParam,
                                      @PathVariable Integer id) {
        adminService.updateUser(userParam, id);
        return MessageResponse.message("用户信息更新成功");
    }

}
