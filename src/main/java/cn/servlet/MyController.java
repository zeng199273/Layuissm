package cn.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.entity.Music;
import cn.service.dao.impl.MusicServiceDaoImpl;
@Controller
public class MyController {
	@Autowired
	private MusicServiceDaoImpl service ;
	
	@RequestMapping(value="/findmusic.action",produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> findMusicController(int page,int limit){
		//分页
		Page<Object> pageh = PageHelper.startPage(page, limit);
		
		//得到所有数据
		List<Music> list = service.findAll();
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageh.getTotal());   //分页总条数
		map.put("data", list);   //得到所有数据
		return map ;
	}
	
	@RequestMapping(value="/findByName.action",produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> findByNameMusicController(String musicName,int page,int limit){
		//分页
		Page<Object> page1 = PageHelper.startPage(page, limit);
		
		//得到模糊查询的数据
		List<Music> list = service.findByNameMusic(musicName);
		//创建map集合，用来存储layui数据表格的数据
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", page1.getTotal());
		map.put("data", list);
		return map ;
	}
	
	@RequestMapping(value="delMusic.action",produces="application/json;charset=utf-8")
	@ResponseBody    //返回json或字符串，阻止页面转发或重定向
	public String delMusicController(int id){
		//得到删除的数据
		service.delMusic(id);
		return "删除成功" ;
	}
	
	@RequestMapping(value="/addMusic.action",produces="application/json;charset=utf-8")
	@ResponseBody
	public String addMusicController(Music mu){
		//得到添加的数据
		service.addMusic(mu);
		return "添加成功";
	}
	
	@RequestMapping("/findMusicById.action")
	public String findMusicByIdController(int id,ModelMap map){
		//得到单个数据
		Music mu = service.findMusicById(id);
		map.addAttribute("mu", mu);
		return "/updateMusic.jsp" ;
	}
	
	@RequestMapping(value="/updateMusic.action",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateMusicController(Music mu){
		//得到修改的数据
		service.updateMusic(mu);
		return "修改成功" ;
	}
}
