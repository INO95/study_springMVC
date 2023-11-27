package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * description :
 * fileName    : ControllerV2
 * author      : ino
 * since       : 2023-11-27
 */
public interface ControllerV2 {
  MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
