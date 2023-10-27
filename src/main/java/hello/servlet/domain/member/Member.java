package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

/**
 * description :
 * fileName    : Member
 * author      : ino
 * since       : 2023-10-28
 */

@Getter
@Setter
public class Member {

  private Long id;

  private String username;

  private int age;

  public Member() {
  }

  public Member(String username, int age) {
    this.username = username;
    this.age = age;
  }
}
