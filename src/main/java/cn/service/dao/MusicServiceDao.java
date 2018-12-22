package cn.service.dao;

import java.util.List;

import cn.entity.Music;
/**
 * service层接口
 * @author Administrator
 * @date 2018年12月10日
 */
public interface MusicServiceDao {
	/**
	 * 查询所有数据的方法
	 * @return
	 */
	public List<Music> findAll();
	/**
	 * 模糊查询数据的方法
	 * @param name
	 * @return
	 */
	public List<Music> findByNameMusic(String musicName);
	/**
	 * 根据id删除数据的方法
	 * @param id
	 */
	public void delMusic(int id);
	/**
	 * 添加数据的方法
	 * @param mu
	 */
	public void addMusic(Music mu);
	/**
	 * 根据id得到数据
	 * @param id
	 * @return
	 */
	public Music findMusicById(int id);
	/**
	 * 修改数据的方法
	 * @param mu
	 */
	public void updateMusic(Music mu);
	
}
