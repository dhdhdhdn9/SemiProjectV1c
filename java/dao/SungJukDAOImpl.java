package sjk.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjk.spring.vo.SungJuk;


@Repository("sjdao")
public class SungJukDAOImpl implements SungJukDAO {
	
	@Autowired
	private SqlSession sqlSession;	

	@Override
	public int insertSungJuk(SungJuk sj) {
		return sqlSession.insert("sungjuk.insertSungJuk", sj);
	}
	
	@Override
	public SungJuk selectOneSungJuk(int sjno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<SungJuk> selectAllSungJuck() {
		return sqlSession.selectList("sungjuk.selectSungJuk");
	}


	@Override
	public int updateSungJuk(SungJuk sj) {
		return 0;
	}

	@Override
	public int deleteSungJuk(int sjno) {
		return sjno;
	}



	
}
