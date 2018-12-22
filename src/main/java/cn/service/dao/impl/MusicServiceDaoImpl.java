package cn.service.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dao.mapper.MusicDao;
import cn.entity.Music;
import cn.service.dao.MusicServiceDao;
/**
 * service层实现类
 * @author Administrator
 * @date 2018年12月10日
 */
@Service
public class MusicServiceDaoImpl implements MusicServiceDao {
	@Autowired
	private MusicDao dao ;

	@Override
	public List<Music> findAll() {
		return dao.findAll();
	}

	@Override
	public void delMusic(int id) {
		dao.delMusic(id);
	}

	@Override
	public void addMusic(Music mu) {
		dao.addMusic(mu);
	}

	@Override
	public Music findMusicById(int id) {
		return dao.findMusicById(id);
	}

	@Override
	public void updateMusic(Music mu) {
		dao.updateMusic(mu);
	}

	@Override
	public List<Music> findByNameMusic(String musicName) {
		return dao.findByNameMusic(musicName);
	}
}
