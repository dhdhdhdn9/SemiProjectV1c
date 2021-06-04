package sjk.spring.dao;

import sjk.spring.vo.Member;

public interface MemberDAO {
	
	int insertMember(Member m);
	int selectLogin(Member m); 
	Member selectOneMember(String userid);
	
}
