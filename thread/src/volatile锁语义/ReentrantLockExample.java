package volatile锁语义;

import java.util.concurrent.locks.ReentrantLock;

//public class ReentrantLockExample {
//		int a = 0;
//		ReentrantLock reentrantLock = new ReentrantLock();
//		
//		public void writer(Thread t){
//			reentrantLock.lock();//获取锁
//			try {
//				a++;
//				
//			}finally{
//				reentrantLock.unlock();//释放锁
//			}
//			
//		}
//		public void reader(Thread t){
//			reentrantLock.lock();//获取锁
//			try {
//				int i = a;
//				System.out.println("线程读："+t.getName()+"a="+a);
//			}finally{
//				reentrantLock.unlock();//释放锁
//			}
//		}
//		public static void main(String[] args){
//			for (int i = 0; i < 1000; i++) {
//			long starttime = System.currentTimeMillis();
//			 final Thread t = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					ReentrantLockExample rle = new ReentrantLockExample();
//					rle.writer(t);
//					rle.reader(t);
//				}
//			});
//			 t.start();
//			long endTime = System.currentTimeMillis();
//			System.out.println("线程数：【"+i+"】名称："+t.getName()+"耗时毫秒："+(endTime - starttime));
//			}
//		}　
//}　　　
