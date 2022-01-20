package com.xb.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-Config.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = factoryBuilder.build(is);
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSqlsession(){
        return sqlSessionFactory.openSession();
    }

    public static void commitAndClose(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }

    public static void rollbackAndClose(SqlSession sqlSession){
        sqlSession.rollback();
        sqlSession.close();
    }

}
