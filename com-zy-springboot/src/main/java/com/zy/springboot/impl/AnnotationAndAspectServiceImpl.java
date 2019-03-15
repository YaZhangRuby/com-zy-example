package com.zy.springboot.impl;

import com.zy.springboot.annotation.LoggerTest;
import com.zy.springboot.service.AnnotationAndAspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: sophie
 * Date: 2019/3/14
 * Time: 11:24
 * Description: A方法调B方法，B方法不走切面(原因：没有通过代理类调B方法，而是调的方法本身)
 * 有三种方法：
 * 方法一：通过类实例本身去调，即modelTestController.methodB()
 * 方法二：通过代理调B方法，即((ModelTestController)AopContext.currentProxy()).methodB();
 * 备注：每个线程都有一个AopContext，存放在ThreadLocal中
 * 方法三：设置B方法的事物为REQUIRES_NEW，commit(注解方式不生效)
 */
@Service
public class AnnotationAndAspectServiceImpl implements AnnotationAndAspectService {

    //方法一
    @Autowired
    private AnnotationAndAspectServiceImpl annotationAndAspectServiceImpl;

    @LoggerTest
    public void methodA() {
        System.out.println("Method A");
        annotationAndAspectServiceImpl.methodB();
    }

    @LoggerTest
    public void methodB()  {
        System.out.println("Method B");
    }

//    方法三：
//    @LoggerTest
//    public ResponseMsg methodB() throws Exception {
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 事物隔离级别，开启新事务
//        TransactionStatus status = txManager.getTransaction(def); // 获得事务状态
//        try {
//            System.out.println("Method B");
//            txManager.commit(status);
//            return new ResponseMsg();
//        } catch (Exception e) {
//            //回滚事务
//            txManager.rollback(status);
//            //抛出异常
//            throw e;
//        }
//    }
}
