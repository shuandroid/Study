package com.chen.study.effectiveJava.singleton;

/**
 * Created by chen on 16-2-22.
 * 使用私有化构造器或枚举类型来强化Singleton属性
 */
public class Test {

    public static final Test INSTANCE = new Test();

    private Test() {
        //方法一
        //添加私有构造函数，保证单例，其他类不可创建该对象的实例

    }

    public void loading() {
        // TODO: 16-2-22 to do something;
    }


    /**
     * 方法二
     * 添加静态工厂方法， 并私有化对象
     */


    private static final Test INSTANCE2 = new Test();

    public static Test getInstance() {
        return INSTANCE2;
    }


}
