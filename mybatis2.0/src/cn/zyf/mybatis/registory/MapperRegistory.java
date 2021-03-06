package cn.zyf.mybatis.registory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import cn.zyf.mybatis.entity.Entity;
import cn.zyf.mybatis.proxy.MapperProxy;
import cn.zyf.mybatis.session.SqlSession;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MapperRegistory {

	public static final Map<String, MapperData> methodSqlMapping = new HashMap<>();
	
	// 使用 1. 在这里配置
		// 2. Java Bean的属性名字要和数据库表的名字一致
	
	static {
		methodSqlMapping.put("cn.zyf.mybatis.mapper.EntityMapper.selectByPrimaryKey",
				new MapperData("select * from mybatis_test where id = %d", Entity.class));
	}

	public <T> T getMapper(Class<T> clazz,SqlSession sqlSession) {
		return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), 
				new Class[]{clazz},
				new MapperProxy(sqlSession));
	}
	
	public static class MapperData<T> {
		private String sql;
		private Class<T> type;

		public MapperData(String sql, Class<T> type) {
			this.sql = sql;
			this.type = type;
		}

		public String getSql() {
			return sql;
		}

		public void setSql(String sql) {
			this.sql = sql;
		}

		public Class<T> getType() {
			return type;
		}

		public void setType(Class<T> type) {
			this.type = type;
		}
	}

	public MapperData get(String nameSpace) {
		return methodSqlMapping.get(nameSpace);
	}

}
