package synchronized��lock������;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	 private Lock lock = new ReentrantLock();//������

	    //��Ҫ����ͬ���ķ���
	    void method(Thread thread){
	        lock.lock();
	        try {
	            System.out.println("�߳���"+thread.getName() + "�������");
	        }catch(Exception e){
	            e.printStackTrace();
	        } finally {
	            System.out.println("�߳���"+thread.getName() + "�ͷ�����");
	            lock.unlock();
	        }
}
	    public static void main(String[] args) {
	        final LockTest lockTest = new LockTest();

	        //�߳�1
	        Thread t1 = new Thread(new Runnable() {

	            @Override
	            public void run() {
	                lockTest.method(Thread.currentThread());
	            }
	        }, "t1");

	        Thread t2 = new Thread(new Runnable() {

	            @Override
	            public void run() {
	                lockTest.method(Thread.currentThread());
	            }
	        }, "t2");

	        t1.start();
	        t2.start();
	    }
	    }
//ִ��������߳���t1�������
//�߳���t1�ͷ�����
//�߳���t2�������
//�߳���t2�ͷ�����