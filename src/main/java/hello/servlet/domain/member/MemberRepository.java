package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description : 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 * fileName    : MemberRepository
 * author      : ino
 * since       : 2023-10-28
 */
public class MemberRepository {

  // static을 선언해서 동시에 한 개만 사용되도록 함
  // 사실, 싱글톤이기 때문에 static이 없어도 된다.
  private static Map<Long, Member> store = new HashMap<>();
  private static long sequence = 0L;

  private static final MemberRepository instance = new MemberRepository();

  // 조회용 get 메서드
  public static MemberRepository getInstance() {
    return instance;
  }

  // 싱글톤 만들 때는 private로 아무나 생성하지 못하도록 막아야 함
  private MemberRepository() {
  }

  public Member save(Member member) {
    // sequence 값 증가시켜서 id 셋
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  public Member findById(Long id) {
    return store.get(id);
  }

  public List<Member> findAll() {
    // store에 있는 모든 값들을 다 꺼내서 새로운 ArrayList에 담아준다.
    // ArrayList의 값을 건드리더라도 store의 값은 변경하고 싶지 않기 때문에 이렇게 만든다.
    return new ArrayList<>(store.values());
  }

  public void clearStore() {
    store.clear();
  }
}
