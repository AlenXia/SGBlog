package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.dto.AddRoleDto;
import com.sangeng.domain.dto.SelectRoleDto;
import com.sangeng.domain.dto.UpdateRoleDto;
import com.sangeng.domain.entity.Role;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.domain.vo.RoleVo;
import com.sangeng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author AlenXia
 * @Date 2022/12/14 22:43
 * @Description 对角色信息的操作
 */
@RestController
@RequestMapping("system/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 角色列表
     * @param pageNum
     * @param pageSize
     * @param roleName
     * @param status
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<PageVo> listAllRole(Integer pageNum, Integer pageSize, String roleName, String status) {
        return roleService.listAllRole(pageNum, pageSize, roleName, status);
    }

    /**
     * 改变角色状态
     * @param roleVo
     * @return
     */
    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody RoleVo roleVo) {
        return roleService.changeStatus(roleVo);
    }

    /**
     * 添加角色
     * @param addRoleDto
     * @return
     */
    @PostMapping
    public ResponseResult addRole(@RequestBody AddRoleDto addRoleDto) {
        return roleService.addRole(addRoleDto);
    }

    /**
     * 角色信息回显接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult<SelectRoleDto> selectByMenuId(@PathVariable("id") Integer id) {
        return roleService.selectById(id);
    }

    /**
     * 更新角色信息
     * @param updateRoleDto
     * @return
     */
    @PutMapping
    public ResponseResult updateRole(@RequestBody UpdateRoleDto updateRoleDto) {
        return roleService.updateRole(updateRoleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteRole(@PathVariable("id") Long id) {
        return roleService.deleteRole(id);
    }

    @GetMapping("/listAllRole")
    public ResponseResult<List<Role>> listResponseResult(){
        return roleService.listResponseResult();
    }
}
