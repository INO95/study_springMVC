package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * description :
 * fileName    : MvcMemberFormServlet
 * author      : ino
 * since       : 2023-10-28
 */
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String viewPath = "/WEB-INF/views/new-form.jsp";
    // Controller -> View 로 이동할 때 사용된다.
    // 서버 내부에서 다시 호출이 발생한다.
    // 1. 클라이언트의 요청 /servlet-mvc/members/new-form
    // 2. 컨트롤러 -> 뷰
    // 3. 뷰 렌더링 -> 클라이언트
    // 리다이렉트 <-> 포워드
    // 리다이렉트 : 클라이언트에 응답을 한 후 클라이언트가 redirect 경로로 다시 한번 호출한다.
    // 즉 클라이언트가 인지(리렌더링) 할 수 있고, URL 경로도 실제로 변경된다.
    // 포워드 : 서버 안에서 내부적으로 메서드를 호출하듯이 행해진다.
    // 즉 클라이언트가 인지할 수 없고, URL경로도 변경되지 않는다.
    // /WEB-INF -> 이 경로안에 JSP가 있으면 외부에서 직접 JSP를 호출할 수 없다
    // 즉, 컨트롤러를 통해서만 JSP를 호출할 수 있도록 해준다.
    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
    dispatcher.forward(request, response);
  }
}
