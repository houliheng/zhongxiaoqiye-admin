package com.gqcc.meim.simple.mcontroller;

import java.util.List;

import javax.annotation.Resource;

import com.gqcc.meim.common.page.ResponseEntity;
import com.gqcc.meim.common.page.ResponsePagesEntityUtil;
import com.gqcc.meim.common.web.BaseController;
import com.gqcc.meim.simple.dao.model.Simple;
import com.gqcc.meim.simple.mcontroller.res.SimpleResForm;
import com.gqcc.meim.simple.service.SimpleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.gqcc.meim.common.interceptor.SysAuthority;
import com.gqcc.meim.common.interceptor.SysAuthority.PrivilegeLevel;
import com.gqcc.meim.common.page.ResponseEntity;
import com.gqcc.meim.common.page.ResponseEntityUtil;
import com.gqcc.meim.common.page.ResponsePagesEntityUtil;
import com.gqcc.meim.common.web.BaseController;
import com.gqcc.meim.simple.dao.model.Simple;
import com.gqcc.meim.simple.mcontroller.req.SimpleReqForm;
import com.gqcc.meim.simple.mcontroller.res.SimpleResForm;
import com.gqcc.meim.simple.service.SimpleService;

@RestController
@RequestMapping(value = "/simple", produces = MediaType.APPLICATION_JSON_VALUE)
public class SimpleMController extends BaseController {
  @Resource
  SimpleService simpleService;

  @RequestMapping(value = "/selectSimpleById/{id}", method = RequestMethod.GET)
  public Object selectSimpleList(@PathVariable("id") Long id) throws Exception {
    SimpleResForm simpleResForm = simpleService.selectSimpleById(id);
    return simpleResForm;
  }

  @RequestMapping(value = "/selectSimpleList", method = RequestMethod.POST)
  @SysAuthority(moduleName = "简单", level = PrivilegeLevel.ALL_PRIVILEGE)
  public ResponsePagesEntityUtil<?> selectSimpleList(@RequestBody SimpleReqForm reqForm) {
    List<Simple> list = simpleService.selectSimpleList(reqForm);
    return ResponseEntityUtil.successPages(list);
  }

  @RequestMapping(value = "/updateSimple", method = RequestMethod.POST)
  public void updateSimple(SimpleReqForm reqForm) throws Exception {
    simpleService.updateSimpleEntity(reqForm);
  }

  @RequestMapping(value = "/insertSimple", method = RequestMethod.GET)
  public ResponseEntity<Void> insertSimple(SimpleReqForm reqForm) throws Exception {
    simpleService.insertSimpleEntity(reqForm);
    return ResponseEntityUtil.success();
  }

  @RequestMapping(value = "/insertSimple/{id}", method = RequestMethod.GET)
  public ResponseEntity<Void> deleteSimpleById(@PathVariable("id") Long id) throws Exception {
    simpleService.deleteSimpleById(id);
    return ResponseEntityUtil.success();
  }
}
