package hello.servlet.web.servlet;

import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * description :
 * fileName    : MemberFormServlet
 * author      : ino
 * since       : 2023-10-28
 */

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

  // 싱글톤
  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // response로 HTML 이 나가야 하기 때문에 ContentBody를 set해야한다.

    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");

    PrintWriter w = response.getWriter();

    w.write("<!DOCTYPE html>\n" +
      "<html>\n" +
      "<head>\n" +
      " <meta charset=\"UTF-8\">\n" +
      " <title>Title</title>\n" +
      "</head>\n" +
      "<body>\n" +
      "<form action=\"/servlet/members/save\" method=\"post\">\n" +
      " username: <input type=\"text\" name=\"username\" />\n" +
      " age: <input type=\"text\" name=\"age\" />\n" +
      " <button type=\"submit\">전송</button>\n" +
      "</form>\n" +
      "</body>\n" +
      "</html>\n");
  }
}