package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * description :
 * fileName    : MemberFormControllerV2
 * author      : ino
 * since       : 2023-11-27
 */
public class MemberFormControllerV2 implements ControllerV2 {
  @Override
  public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // ctrl + alt + n -> inline (한줄로)
    return new MyView("/WEB-INF/views/new-form.jsp");
  }
}
