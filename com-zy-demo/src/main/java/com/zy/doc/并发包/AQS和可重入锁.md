#### ReentrantLock和AQS的关系

    用java并发包下的ReentrantLock可以实现加锁和解锁，一般如下所示：

```
ReentrantLock lock = new ReentrantLock();
lock.lock();   //加锁

....   //处理业务逻辑

lock.unlock();    //解锁
```

   java并发包下很多api都是基于AQS实现加锁和解锁功能的，AQS是并发包的基础类。比如ReentrantLock和ReentrantReadWriteLock底层都是基于AQS来实现的。
   
   **AQS的全称是AbstractQueuedSynchronizer，抽象队列同步器。**
   
   ReentrantLock和AQS之间的关系如下图所示：说白了，ReentrantLock内部包含了一个AQS对象，也就是AbstractQueuedSynchronizer类型的对象。这个AQS对象对象就是ReentrantLock可以实现加锁和释放锁的关键性的核心组件。
   ![ReentrantLock和AQS的关系](/Users/zhangya/ideaprojects/com-zy-example/com-zy-demo/src/test/java/picture/AQS和ReentrantLock的关系.jpg '''')

   
   
   
   
   
   
   
#### ReentrantLock加锁和释放锁的底层原理
