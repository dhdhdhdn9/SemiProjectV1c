package sjk.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjk.spring.dao.SungJukDAO;
import sjk.spring.vo.SungJuk;

/*Service Class에서 쓰인다.
비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도이다.
괄호 안에는 호출하고자하는 Service 패키지 내의 코드(비즈니스 로직과 관련된 모든 코드)를 넣는다*/
@Service("sjsrv")
public class SungJukServiceImpl implements SungJukService {

	/* 필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.
	 * 타입: 생성자, setter, 필드
	 * Autowired는 기본값이 true이기 때문에 
	 * 의존성 주입을 할 대상을 찾지 못한다면 애플리케이션 구동에 실패한다.*/
	
	@Autowired
	private SungJukDAO sjdao;
	 
	
	@Override
	public int newSungJuk(SungJuk sj) {
		computeSungJuk(sj);
		return sjdao.insertSungJuk(sj);
	}	
	
	@Override
	public void computeSungJuk(SungJuk sj) {
		int tot = sj.getKor() + sj.getEng() + sj.getMat();
		double avg = tot / 3.0; 
		String grd = "가";
		
		if (avg >= 90) grd = "수";
		else if (avg >= 80) grd = "우";
		else if (avg >= 70) grd = "미";
		else if (avg >= 60) grd = "양";
		
		sj.setTot(tot);
		sj.setAvg(avg);
		sj.setGrd(grd.charAt(0));
	}

	
	@Override
	public List<SungJuk> readAllSungJuk() {
		return sjdao.selectAllSungJuck();
	}

	
	@Override
	public SungJuk readOneSungJuk(int sjno) {
		return null;
	}

	@Override
	public int modifySungJuk() {
		return 0;		
	}

	@Override
	public int removeSungJuk() {
		return 0;
	}


}
