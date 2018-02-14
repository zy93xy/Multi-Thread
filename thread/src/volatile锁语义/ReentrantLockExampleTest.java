package volatile锁语义;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExampleTest {
	int a = 0;
	ReentrantLock reentrantLock = new ReentrantLock();
	
	public void writer(){
		reentrantLock.lock();//获取锁
		 
		try {
			a++;
//			System.out.println("线程读：a="+a);
		}finally{
			reentrantLock.unlock();//释放锁
		}
		
	}
	
	public void reader(){
		reentrantLock.lock();//获取锁
		
		try {
			int i = a;
			System.out.println("线程读：a="+a);
		}finally{
			reentrantLock.unlock();//释放锁
		}
	}
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			long starttime = System.currentTimeMillis();
			 final Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					ReentrantLockExampleTest rle = new ReentrantLockExampleTest();
					rle.writer();
					rle.reader();
					
				}
			});
			 t.start();
//			 t.sleep(5000);//对线程之休眠，可以让无序执行的程序语义变得井然有序
//			 t.checkAccess(); //这里使用没有任何意义
//			 t.countStackFrames();//过时
//			 t.destroy();//过时
//			 t.getStackTrace();
//			 System.out.println("ReentrantLockExampleTest.main()"+t.isAlive());//这个重排序之后第一执行为true是就可以井然有序的执行程序语义了
//			 System.out.println("    "+t.isDaemon()); //执行为false，且是井然有序
//			 t.join();//使用是也是井然有序的
//			 t.wait(5000); //
			 long endTime = System.currentTimeMillis();
			 System.out.println("名称："+t.getName()+"耗时毫秒："+(endTime - starttime));
			}

	}

}
