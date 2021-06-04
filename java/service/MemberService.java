package sjk.spring.service;

import sjk.spring.vo.Member;

public interface MemberService {
	
	int newMember(Member m);
	int LoginMember(Member m);
	Member readOneMember(String userid);

}
