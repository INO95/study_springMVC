package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * description :
 * fileName    : ControllerV1
 * author      : ino
 * since       : 2023-10-28
 */

// 인터페이스를 만들어서 활용한다. (다형성)
public interface ControllerV1 {

  // 서블릿과 비슷한 모양
  void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
