package sjk.spring.dao;

import java.util.List;

import sjk.spring.vo.SungJuk;

public interface SungJukDAO {
	int insertSungJuk(SungJuk sj);
	List<SungJuk> selectAllSungJuck();
	SungJuk selectOneSungJuk(int sjno);
	int updateSungJuk(SungJuk sj);
	int deleteSungJuk(int i);
}
