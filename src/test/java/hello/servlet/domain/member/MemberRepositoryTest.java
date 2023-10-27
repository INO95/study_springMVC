package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * description :
 * fileName    : MemberRepositoryTest
 * author      : ino
 * since       : 2023-10-28
 */
class MemberRepositoryTest {

  MemberRepository memberRepository = MemberRepository.getInstance();

  // 테스트가 끝나면 초기화를 해준다.
  // 테스트의 순서가 보장이 되지 않기 때문에 테스트 시작 전 무조건 해준다.
  @AfterEach
  void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void save() {
    // given
    // -> 이런게 주어졌을 때
    Member member = new Member("hello", 20);

    // when
    // -> 이런걸 실행했을 때
    Member savedMember = memberRepository.save(member);

    // then
    // -> 결과는 이러해야 한다
    Member findMember = memberRepository.findById(savedMember.getId());
    assertThat(findMember).isEqualTo(savedMember);
  }

  @Test
  void findById() {
    //given
    Member member1 = new Member("member1", 20);
    Member member2 = new Member("member2", 30);

    memberRepository.save(member1);
    memberRepository.save(member2);
    //when
    List<Member> result = memberRepository.findAll();

    //then
    // alt + enter : static import가 자동으로 들어감, 메서드를 바로 쓸 수 있다.
    assertThat(result.size()).isEqualTo(2);
    assertThat(result).contains(member1, member2);
  }

  @Test
  void findAll() {
  }

  @Test
  void clearStore() {
  }
}