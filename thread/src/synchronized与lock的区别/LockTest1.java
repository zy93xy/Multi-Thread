package synchronized��lock������;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest1 {
	 private Lock lock = new ReentrantLock();

	    //��Ҫ����ͬ���ķ���
	    private void method(Thread thread){
	/*      lock.lock();
	        try {
	            System.out.println("�߳���"+thread.getName() + "�������");
	        }catch(Exception e){
	            e.printStackTrace();
	        } finally {
	            System.out.println("�߳���"+thread.getName() + "�ͷ�����");
	            lock.unlock();
	        }*/


	        if(lock.tryLock()){
	            try {
	                System.out.println("�߳���"+thread.getName() + "�������");
	            }catch(Exception e){
	                e.printStackTrace();
	            } finally {
	                System.out.println("�߳���"+thread.getName() + "�ͷ�����");
	                lock.unlock();
	            }
	        }else{
	            System.out.println("����"+Thread.currentThread().getName()+"����ռ�������ҾͲ�Ҫ��");
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