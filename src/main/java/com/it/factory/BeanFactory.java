package com.it.factory;

/*
* 創建bean對象的工廠
*
* Bean在計算機英語中 有可重用組件的含義
* JavaBean : 用java語言編寫的 可重用組件
*   javabean != 實體類
*   他就是創建我們的service and dao
*   第一個: 需要一個配置文件來配置service and dao
*       配置的內容: 唯一標示符=>全限定類名(key=>value)
*   第二個: 通過讀取配置文件中配置的內容 反射創建對象
*
*   配置文件可以是xml也可以是properties(properties較簡單)
* */

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties props;

    //定義一個map 用於存放我們要創建的對象 稱之為容器
    private static Map<String, Object> beans;

    //使用靜態代碼塊為properties對象賦值
    static{
        try{
            //實例化對象
            props = new Properties();

            //獲取properties文件的流對象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);

            //實例化容器
            beans =new HashMap<String, Object>();


            //取出配置文件中所有的key
            Enumeration keys = props.propertyNames();

            //遍歷枚舉
            while(keys.hasMoreElements()){
                //取出每個key
                String key = keys.nextElement().toString();

                //根據key 取得value
                String beanPath = props.getProperty(key);

                //反射創建對象
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();

                //key value 存入map
                beans.put(key, value);
            }


        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失敗");

        }
    }

    /**
     * 根據bean的名稱獲取bean對象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

//    public static Object getBean(String beanName){
//        Object bean = null;
//        try{
//            String beanPath = props.getProperty(beanName);
//            //newInstance 每次都會調用構造函數初始對象
//            bean = Class.forName(beanPath).getDeclaredConstructor().newInstance();
//            System.out.println(beans.get(beanName));
//
//            //return beans.get(beanName);
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//        //return beans.get(beanName);
//    }
}
