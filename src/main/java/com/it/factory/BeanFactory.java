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
import java.util.Properties;

public class BeanFactory {
    private static Properties props;

    //使用靜態代碼塊為properties對象賦值
    static{
        //實例化對象
        props = new Properties();
        //獲取properties文件的流對象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失敗");
        }
    }

    /**
     * 根據bean的名稱獲取bean對象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        Object bean = null;
        try{
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).getDeclaredConstructor().newInstance();
        } catch(Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
