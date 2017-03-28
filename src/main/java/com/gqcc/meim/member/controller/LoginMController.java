package com.gqcc.meim.member.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.gqcc.meim.common.web.BaseController;
import com.gqcc.meim.member.controller.req.LoginReqForm;
import com.gqcc.meim.member.controller.res.MemberResForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gqcc.meim.common.page.ResponseEntity;
import com.gqcc.meim.common.page.ResponseEntityUtil;
import com.gqcc.meim.member.service.LoginService;

/**
 * @author YS yanshuang@nxin.com
 * @ClassName: LoginMController
 * @Description: 登录移动端
 * @createTime 2016/12/1 19:01
 */
@RestController
@RequestMapping(value = "/mob/member", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginMController extends BaseController {

  static Logger logger = LoggerFactory.getLogger(LoginMController.class);
  @Resource
  LoginService loginService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<MemberResForm> sendLogin(@Valid LoginReqForm form) throws Exception {
    MemberResForm memberResForm =
        loginService.loginMember(form.getMobilePhone(), form.getPassword());
    return ResponseEntityUtil.success(memberResForm);
  }
}
