package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * description :
 * fileName    : FrontControllerServletV1
 * author      : ino
 * since       : 2023-10-28
 */

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

  // 각 요청마다 컨트롤러를 나눠주기 위하여 Map 형태로 각 컨트롤러를 선언해둔다.
  private Map<String, ControllerV1> controllerMap = new HashMap<>();

  public FrontControllerServletV1() {
    controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
    controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
    controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("FrontControllerServletV1.service");

    String requestURI = request.getRequestURI();

    ControllerV1 controller = controllerMap.get(requestURI);
    if (Objects.isNull(controller)) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    controller.process(request, response);

    /*
    * 구조를 개선할 때는 구조만 개선하고 기존 코드는 최대한 유지시켜야 한다.
    */
  }
}
